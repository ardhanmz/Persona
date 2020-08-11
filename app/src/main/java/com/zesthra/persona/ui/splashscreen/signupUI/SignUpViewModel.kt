package com.zesthra.persona.ui.splashscreen.signupUI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zesthra.persona.data.db.datasource.UserDataSource
import javax.inject.Inject

class SignUpViewModel @Inject constructor( val dataSource: UserDataSource) : ViewModel() {
    // TODO: Implement the ViewModel
    val result = MutableLiveData<String>()
    fun CheckUIMode(){

    }
//    fun signUp(username : String){
//        Coroutines.io {
//            try {
//                val user = User()
//                user.username = username
//                dataSource.userdao?.insert(user)
//                val checkinsertdata = dataSource.userdao?.findByUsername(username)
//                if(checkinsertdata?.username.equals(username)){
//                    result.value = "OK"
//                }else {
//                    result.value = "NOT FOUND"
//                }
//            }catch (ex : Exception){
//
//            }
//        }
//    }
}
