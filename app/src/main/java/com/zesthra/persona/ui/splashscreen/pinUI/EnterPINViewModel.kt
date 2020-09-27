package com.zesthra.persona.ui.splashscreen.pinUI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.repositories.LocalUserRepository

class EnterPINViewModel(val localUserRepository: LocalUserRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    var isBiometricAvailable = false
    var pin : Int = 0
    lateinit var username : String

    fun getListUser(): LiveData<List<User?>?>? {
        return localUserRepository.findAll()
    }
}