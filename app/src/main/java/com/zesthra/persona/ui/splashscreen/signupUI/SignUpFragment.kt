package com.zesthra.persona.ui.splashscreen.signupUI

import android.content.res.Configuration
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.zesthra.persona.R

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val isNightTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                when (isNightTheme) {
                    Configuration.UI_MODE_NIGHT_YES ->
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    Configuration.UI_MODE_NIGHT_NO ->
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
        return inflater.inflate(R.layout.sign_up_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}