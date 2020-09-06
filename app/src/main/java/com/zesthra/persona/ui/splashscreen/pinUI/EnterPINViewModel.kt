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

    fun saveUser(user: User){
        try{
            Coroutines.io {
                localUserRepository.insertUser(user)
            }
        }catch (ex : Exception){
            Log.e(Global.tag_err_save_usr, ex.message!!)
        }

    }
    fun getListUser(): LiveData<List<User?>?>? {
        return localUserRepository.findAll()
    }
}