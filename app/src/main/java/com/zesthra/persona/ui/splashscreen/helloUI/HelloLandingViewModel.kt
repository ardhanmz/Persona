package com.zesthra.persona.ui.splashscreen.helloUI

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.zesthra.persona.R
import com.zesthra.persona.data.db.datasource.UserDataSource
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.repositories.UserRepository
import javax.inject.Inject

class HelloLandingViewModel @Inject constructor(
    private val repository: UserDataSource?
): ViewModel() {

    fun getListUser(): LiveData<List<User?>?>? {
        return repository?.userdao?.getUserList()
    }


}