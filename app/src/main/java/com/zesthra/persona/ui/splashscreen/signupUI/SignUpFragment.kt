package com.zesthra.persona.ui.splashscreen.signupUI

import android.content.res.Configuration
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.zesthra.persona.Persona
import com.zesthra.persona.R
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.databinding.FragmentHelloLandingBinding
import com.zesthra.persona.databinding.SignUpFragmentBinding
import com.zesthra.persona.ui.splashscreen.helloUI.HelloLandingViewModel
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject
import javax.inject.Inject

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    
    private val sharedPref : PreferenceProvider by inject()
    private lateinit var viewModel: SignUpViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        val binding: SignUpFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)
        binding.viewmodel = viewModel
        return  binding.root
    }


}