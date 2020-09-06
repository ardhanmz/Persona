package com.zesthra.persona.ui.splashscreen.modeUI

import androidx.lifecycle.ViewModel
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