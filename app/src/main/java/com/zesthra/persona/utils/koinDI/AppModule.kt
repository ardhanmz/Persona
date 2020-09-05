package com.zesthra.persona.utils.koinDI

import com.zesthra.persona.data.db.AppDatabase
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.data.repositories.LocalUserRepository
import com.zesthra.persona.ui.splashscreen.helloUI.HelloLandingViewModelFactory
import com.zesthra.persona.ui.splashscreen.modeUI.DarkModeLandingViewModelFactory
import com.zesthra.persona.ui.splashscreen.pinUI.EnterPINViewModelFactory
import com.zesthra.persona.ui.splashscreen.signupUI.SignUpViewModelFactory
import org.koin.dsl.module

val AppModule = module {

    single { AppDatabase(get()) }
    single { LocalUserRepository(get()) }
    single { PreferenceProvider(get())}


    factory {HelloLandingViewModelFactory(get())}
    factory { DarkModeLandingViewModelFactory(get()) }
    factory { EnterPINViewModelFactory(get()) }
    factory { SignUpViewModelFactory(get()) }
}