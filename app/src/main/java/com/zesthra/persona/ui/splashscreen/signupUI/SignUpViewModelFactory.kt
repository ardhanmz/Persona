package com.zesthra.persona.ui.splashscreen.signupUI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zesthra.persona.data.repositories.LocalUserRepository
import com.zesthra.persona.ui.splashscreen.pinUI.EnterPINViewModel

class SignUpViewModelFactory (
    val localUserRepository: LocalUserRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel(localUserRepository) as T
    }
}