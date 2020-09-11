package com.zesthra.persona.ui.splashscreen.pinUI

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.repositories.LocalUserRepository
import com.zesthra.persona.utils.Coroutines
import com.zesthra.persona.utils.Global
import java.lang.Exception

class EnterPINViewModel(val localUserRepository: LocalUserRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    var isBiometricAvailable = false
    var pin : Int = 0
    lateinit var username : String

    fun getListUser(): LiveData<List<User?>?>? {
        return localUserRepository.findAll()
    }
}