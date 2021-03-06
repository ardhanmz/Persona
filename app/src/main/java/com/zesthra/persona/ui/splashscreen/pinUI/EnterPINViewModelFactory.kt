package com.zesthra.persona.ui.splashscreen.pinUI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zesthra.persona.data.repositories.LocalUserRepository

class EnterPINViewModelFactory (
    val localUserRepository: LocalUserRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EnterPINViewModel(localUserRepository) as T
    }
}