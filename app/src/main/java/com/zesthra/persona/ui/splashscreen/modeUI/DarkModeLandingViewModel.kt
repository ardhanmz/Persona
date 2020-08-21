package com.zesthra.persona.ui.splashscreen.modeUI

import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.zesthra.persona.R
import com.zesthra.persona.data.preferences.PreferenceProvider

class DarkModeLandingViewModel(
    val sharedPreference : PreferenceProvider
) : ViewModel() {
    // TODO: Implement the ViewModel
    fun selectLightMode(){
        sharedPreference.saveUIMode(false)
    }
    fun selectDarkMode(){
        sharedPreference.saveUIMode(true)
    }
    fun checkUIMode(): Boolean? {
        return sharedPreference.getUIMode()
    }
}