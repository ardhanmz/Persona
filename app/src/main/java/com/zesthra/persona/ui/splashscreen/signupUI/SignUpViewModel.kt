package com.zesthra.persona.ui.splashscreen.signupUI

import android.util.Log
import androidx.lifecycle.ViewModel
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.repositories.LocalUserRepository
import com.zesthra.persona.utils.Coroutines
import com.zesthra.persona.utils.Global
import java.lang.Exception

class SignUpViewModel(val localUserRepository: LocalUserRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    var username : String = ""
    var pincode : Int = 0
    var exceptionMSG: String = ""

    fun createDataUser() : User{
        return User(1, username, pincode)
    }

    fun saveUser(user: User){
        try{
            Coroutines.io {
                localUserRepository.insertUser(user)
            }
        }catch (ex : Exception){
            Log.e(Global.tag_err_save_usr, ex.message!!)
            exceptionMSG = ex.message.toString()
        }

    }

}
