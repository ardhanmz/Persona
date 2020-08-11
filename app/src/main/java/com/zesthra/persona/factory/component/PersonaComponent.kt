package com.zesthra.persona.factory.component

import android.app.Application
import android.content.SharedPreferences
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.factory.module.AppModule
import com.zesthra.persona.factory.module.PreferenceModule
import com.zesthra.persona.factory.module.RoomModule
import com.zesthra.persona.ui.splashscreen.DarkModeLandingFragment
import com.zesthra.persona.ui.splashscreen.helloUI.HelloLandingFragment
import com.zesthra.persona.ui.splashscreen.signupUI.SignUpFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RoomModule::class, AppModule::class, PreferenceModule::class])
interface PersonaComponent {

//    fun inject(helloLandingFragment: HelloLandingFragment)
////    fun inject(signUpFragment: SignUpFragment)
////    fun inject(darkModeLandingFragment: DarkModeLandingFragment)
////    fun inject(application: Application)
////
////    fun prefManager(): SharedPreferences?
////
////    fun preferencesHelper(): PreferenceProvider?

}