package com.zesthra.persona.ui.splashscreen.modeUI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zesthra.persona.data.preferences.DataStoreProvider
import com.zesthra.persona.data.preferences.PreferenceProvider

class DarkModeLandingViewModelFactory (
    private val sharedPreferences : PreferenceProvider,
    private val dataStoreProvider: DataStoreProvider
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DarkModeLandingViewModel(sharedPreferences, dataStoreProvider) as T
    }
}