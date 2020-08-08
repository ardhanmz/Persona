package com.zesthra.persona.factory.module

import com.zesthra.persona.ui.splashscreen.DarkModeLandingFragment
import com.zesthra.persona.ui.splashscreen.helloUI.HelloLandingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeHelloLandingFragment(): HelloLandingFragment

    @ContributesAndroidInjector
    abstract fun contributeDarkModeLandingFragment(): DarkModeLandingFragment
}