package com.zesthra.persona.ui.splashscreen.signupUI

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
import com.zesthra.persona.R
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.databinding.SignUpFragmentBinding
import kotlinx.android.synthetic.main.enter_p_i_n_fragment.*
import kotlinx.android.synthetic.main.sign_up_fragment.*
import kotlinx.android.synthetic.main.sign_up_fragment.view.*
import org.koin.android.ext.android.inject

class SignUpFragment : Fragment() {

    private val viewModelFactory : SignUpViewModelFactory by inject()
    private lateinit var viewModel: SignUpViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: SignUpFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SignUpViewModel::class.java)
        binding.viewmodel = viewModel
        handleViewComponent(binding)
        return  binding.root
    }

    fun handleViewComponent(binding: SignUpFragmentBinding) {
        //Handle TextInput Username
        binding.textinputlayoutusername.textinputedittextusername.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0?.length!! < 1){
                    textinputlayoutusername.setError(getString(R.string.error_insert_username));
                    textinputlayoutusername.setErrorEnabled(true);
                }else if(p0.length > 8){
                    textinputlayoutusername.setError(getString(R.string.err_username_exceeded));
                    textinputlayoutusername.setErrorEnabled(true);
                }
                else{
                    viewModel.username = p0.toString()
                    textinputlayoutusername.setErrorEnabled(false)
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        //Handle TextInput PIN
        binding.textinputlayoutpin.textinputedittextpin.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //TODO("Get PIN Data And Validate it")
                if(p0?.length!! < 1){
                    textinputlayoutpin.setError(getString(R.string.error_insert_username));
                    textinputlayoutpin.setErrorEnabled(true);
                }else if(p0.length > 8){
                    textinputlayoutpin.setError(getString(R.string.err_username_exceeded));
                    textinputlayoutpin.setErrorEnabled(true);
                }
                else{
                    viewModel.PIN = Integer.parseInt(p0.toString())
                    textinputlayoutusername.setErrorEnabled(false)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                //TODO("Not yet implemented")
            }

        })
        //Handle Register Button
        binding.button.setOnClickListener { view : View ->
            if(!textinputlayoutusername.isErrorEnabled && viewModel.username.isNotEmpty() ||
                    viewModel.PIN != 0 && !textinputlayoutpin.isErrorEnabled){
                val user = viewModel.createDataUser();
                viewModel.saveUser(user)
                if(viewModel.exceptionMSG.length ==0){
                    view.findNavController().navigate(R.id.action_signUpFragment_to_homeActivity)
                }
            }
        }
    }




}