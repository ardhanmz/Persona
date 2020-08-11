package com.zesthra.persona.ui.splashscreen.helloUI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.repositories.LocalUserRepository

class HelloLandingViewModel(
    private val localUserRepository: LocalUserRepository
): ViewModel() {

    fun getListUser(): LiveData<List<User?>?>? {
        return localUserRepository.findAll()
    }


}