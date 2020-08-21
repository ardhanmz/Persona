
package com.zesthra.persona

import android.app.Application
import com.zesthra.persona.utils.koinDI.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Persona : Application() {
    override fun onCreate() {
        super.onCreate()
        //KOIN Init
        startKoin {
            // declare used Android context
            androidContext(this@Persona)
            // declare modules
            modules(AppModule)
        }

    }



}