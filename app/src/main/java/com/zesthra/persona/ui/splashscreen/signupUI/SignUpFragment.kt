package com.zesthra.persona.ui.splashscreen.signupUI

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.zesthra.persona.R
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.databinding.FragmentHelloLandingBinding
import com.zesthra.persona.databinding.SignUpFragmentBinding
import com.zesthra.persona.ui.splashscreen.helloUI.HelloLandingViewModel
import com.zesthra.persona.ui.splashscreen.pinUI.EnterPINFragmentDirections
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject
import javax.inject.Inject

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    
    private val sharedPref : PreferenceProvider by inject()
    private lateinit var viewModel: SignUpViewModel
    private var username : String = "";



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: SignUpFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        binding.viewmodel = viewModel
        binding.button.setOnClickListener { view : View ->
            viewModel.username = binding.editText.text.toString()
            if(viewModel.username.length<1){
                Toast.makeText(context, activity?.getString(R.string.error_insert_username), Toast.LENGTH_LONG).show()
            }else{
                val action = SignUpFragmentDirections.actionSignUpFragmentToEnterPINFragment2(viewModel.username);
                view.findNavController().navigate(action)
            }
        }
        return  binding.root
    }




}