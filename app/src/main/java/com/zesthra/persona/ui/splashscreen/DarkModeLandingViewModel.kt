package com.zesthra.persona.ui.splashscreen

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.zesthra.persona.R

class DarkModeLandingViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    fun selectDarkMode(view: View) {
        view.findNavController().navigate(R.id.action_mode_to_homeactivity);
    }
    fun selectLightMode(){

    }
    fun skipSelection(){

    }
}