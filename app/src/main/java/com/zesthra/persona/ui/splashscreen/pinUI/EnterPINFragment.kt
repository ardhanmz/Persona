package com.zesthra.persona.ui.splashscreen.pinUI

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.zesthra.persona.R
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.databinding.EnterPINFragmentBinding
import kotlinx.android.synthetic.main.enter_p_i_n_fragment.*
import org.koin.android.ext.android.inject

class EnterPINFragment : Fragment() {


    val args: EnterPINFragmentArgs by navArgs()
    lateinit var username : String
    var pin : Int = 0

    val factory: EnterPINViewModelFactory by inject()

    private lateinit var viewModel: EnterPINViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : EnterPINFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.enter_p_i_n_fragment, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(EnterPINViewModel::class.java)
        binding.viewmodel = viewModel;
        username = args.username;
        binding.textinputlayoutPIN.editText?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0?.length!! < 1){
                    textinputlayoutPIN.setError(getString(R.string.err_pin_required));
                    textinputlayoutPIN.setErrorEnabled(true);
                }else if(p0.length > 4){
                    textinputlayoutPIN.setError(getString(R.string.err_pin_exceeded));
                    textinputlayoutPIN.setErrorEnabled(true);
                }
                else{
                    pin = Integer.parseInt(p0.toString())
                    textinputlayoutPIN.setErrorEnabled(false)
                }
            }


            override fun afterTextChanged(p0: Editable?) {

            }

        })
        binding.btnNext.setOnClickListener { view : View ->
            if(pin != 0){
                val user = User(1,username, pin)
                viewModel.saveUser(user)
                view.findNavController().navigate(R.id.action_enterPINFragment_to_homeActivity)
            }else{
                Toast.makeText(context, "PIN Undefined", Toast.LENGTH_SHORT).show()
            }

        }
        return binding.root
    }


}