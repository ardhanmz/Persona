package com.zesthra.persona.ui.splashscreen.modeUI

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.zesthra.persona.R
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.databinding.DarkModeLandingFragmentBinding
import com.zesthra.persona.ui.splashscreen.helloUI.HelloLandingViewModelFactory
import org.koin.android.ext.android.inject


class DarkModeLandingFragment : Fragment() {


    private val factory : DarkModeLandingViewModelFactory by inject()

    private lateinit var viewModel: DarkModeLandingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
//
//        (activity?.application as Persona)
//            .getPersonaComponent()
//            ?.inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : DarkModeLandingFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.dark_mode_landing_fragment, container, false);
        viewModel = ViewModelProviders.of(this, factory).get(DarkModeLandingViewModel::class.java);
        binding.viewmodel = viewModel;
        binding.btnDark.setOnClickListener { view: View ->
            AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
            viewModel.selectDarkMode()
        }
        binding.btnLight.setOnClickListener { view: View ->
            AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
            viewModel.selectLightMode();
        }
        binding.btnNext.setOnClickListener { view: View ->
            val action = DarkModeLandingFragmentDirections.actionDarkModeLandingFragment2ToSignUpFragment2()
            view.findNavController().navigate(action)
        }
        binding.btnSkip.setOnClickListener { view: View ->
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            val action = DarkModeLandingFragmentDirections.actionDarkModeLandingFragment2ToSignUpFragment2()
            view.findNavController().navigate(action)
        }
        return binding.root;
    }


    override fun onResume() {
        super.onResume()
        if(viewModel.checkUIMode()==true){
            AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}