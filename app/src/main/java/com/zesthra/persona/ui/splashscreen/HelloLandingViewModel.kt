package com.zesthra.persona.ui.splashscreen

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.zesthra.persona.R

class HelloLandingViewModel: ViewModel() {
    fun toSelectMode(view: View) {
        view.findNavController().navigate(R.id.action_hello_to_darkmode)
    }
}