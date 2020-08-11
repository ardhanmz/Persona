package com.zesthra.persona.ui.splashscreen.helloUI


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zesthra.persona.data.repositories.LocalUserRepository


class HelloLandingViewModelFactory(
    private val repository: LocalUserRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HelloLandingViewModel(repository) as T
    }
}
