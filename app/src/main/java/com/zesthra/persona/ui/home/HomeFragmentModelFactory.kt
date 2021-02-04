package com.zesthra.persona.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zesthra.persona.data.repositories.LocalUserRepository

class HomeFragmentModelFactory (
    private val localUserRepository: LocalUserRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(localUserRepository) as T
    }
}