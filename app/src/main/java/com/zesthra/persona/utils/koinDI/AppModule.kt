package com.zesthra.persona.utils.koinDI

import com.zesthra.persona.data.db.AppDatabase
import com.zesthra.persona.data.preferences.DataStoreProvider
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.data.repositories.LocalUserRepository
import com.zesthra.persona.ui.home.HomeFragmentModelFactory
import com.zesthra.persona.ui.home.HomeViewModel
import com.zesthra.persona.ui.splashscreen.helloUI.HelloLandingViewModelFactory
import com.zesthra.persona.ui.splashscreen.modeUI.DarkModeLandingViewModelFactory
import com.zesthra.persona.ui.splashscreen.pinUI.EnterPINViewModelFactory
import com.zesthra.persona.ui.splashscreen.signupUI.SignUpViewModelFactory
import org.koin.dsl.module

val AppModule = module {

    single { AppDatabase(get()) }
    single { LocalUserRepository(get()) }
    single { PreferenceProvider(get())}
    single { DataStoreProvider(get()) }

    //User DAO Singleton
    single { get<AppDatabase>().getUserDao()}


    factory {HelloLandingViewModelFactory(get())}
    factory { DarkModeLandingViewModelFactory(get(), get()) }
    factory { EnterPINViewModelFactory(get()) }
    factory { SignUpViewModelFactory(get()) }
    factory { HomeFragmentModelFactory(get()) }
}