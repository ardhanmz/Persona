package com.zesthra.persona.ui.splashscreen.modeUI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.ui.splashscreen.helloUI.HelloLandingViewModel

class DarkModeLandingViewModelFactory (
    private val sharedPreferences : PreferenceProvider
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DarkModeLandingViewModel(sharedPreferences) as T
    }
}