package com.zesthra.persona.ui.splashscreen.signupUI

import android.util.Log
import androidx.lifecycle.ViewModel
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.repositories.LocalUserRepository
import com.zesthra.persona.utils.Coroutines
import com.zesthra.persona.utils.Global
import java.lang.Exception
import java.time.Instant

class SignUpViewModel(val localUserRepository: LocalUserRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    var username : String = ""
    var pincode : Int = 0
    var exceptionMSG: String = ""
    val dtmCRT = System.currentTimeMillis()
    val income : Int = 0

    fun createDataUser() : User{
        return User(1, dtmCRT, username, pincode, income)
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
