package com.zesthra.persona.ui.splashscreen

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.zesthra.persona.Persona
import com.zesthra.persona.R
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.databinding.DarkModeLandingFragmentBinding
import com.zesthra.persona.factory.component.DaggerPersonaComponent
import com.zesthra.persona.factory.module.AppModule
import com.zesthra.persona.factory.module.PreferenceModule
import com.zesthra.persona.factory.module.RoomModule
import com.zesthra.persona.utils.Global
import org.koin.android.ext.android.inject


class DarkModeLandingFragment : Fragment() {

    companion object {
        fun newInstance() = DarkModeLandingFragment()
    }

    private val sharedPref : PreferenceProvider by inject()
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
        viewModel = ViewModelProviders.of(this).get(DarkModeLandingViewModel::class.java);
        binding.viewmodel = viewModel;
        binding.btnDark.setOnClickListener { view: View ->
            AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
        }
        binding.btnLight.setOnClickListener { view: View ->
            AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
        }
        binding.btnNext.setOnClickListener { view: View ->
            val isNightTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            when (isNightTheme) {
                Configuration.UI_MODE_NIGHT_YES ->
                    sharedPref.saveUIMode(true)
                Configuration.UI_MODE_NIGHT_NO ->
                    sharedPref.saveUIMode(false)
            }
//            if(sharedPref.getUIMode()==true){
//                Toast.makeText(context, "Gelap", Toast.LENGTH_SHORT).show()
//            }else {
//                Toast.makeText(context, "Terang", Toast.LENGTH_SHORT).show()
//            }
            view.findNavController().navigate(R.id.action_darkModeLandingFragment2_to_signUpFragment2);
        }
        binding.btnSkip.setOnClickListener { view: View ->
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
        return binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DarkModeLandingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}