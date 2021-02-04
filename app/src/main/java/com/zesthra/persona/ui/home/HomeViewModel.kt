package com.zesthra.persona.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.repositories.LocalUserRepository

class HomeViewModel(
    private val localUserRepository: LocalUserRepository
) : ViewModel() {
    var username="";
    var income = 0;
    // TODO: Implement the ViewModel
    fun getListUser(): LiveData<List<User?>?>? {
        return localUserRepository.findAll()
    }
}