package com.zesthra.persona.ui.splashscreen.helloUI


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zesthra.persona.data.db.datasource.UserDataSource
import com.zesthra.persona.data.repositories.UserRepository
import javax.inject.Inject
import javax.inject.Provider

class HelloLandingViewModelFactory @Inject constructor(
   val userDataSource: UserDataSource
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HelloLandingViewModel(userDataSource) as T
    }


}
