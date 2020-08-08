package com.zesthra.persona.factory.module

import android.app.Application
import com.zesthra.persona.Persona
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule constructor(val persona: Persona? ){
    private val application: Persona? = null
    var mApplication: Application? = application

    @Provides
    fun providePersona(): Persona? {
        return application
    }
    @Provides
    @Singleton
    fun providesApplication(): Application? {
        return mApplication
    }

}