
package com.zesthra.persona

import android.app.Application
import com.zesthra.persona.factory.component.DaggerPersonaComponent
import com.zesthra.persona.factory.component.PersonaComponent
import com.zesthra.persona.factory.module.AppModule
import com.zesthra.persona.factory.module.PreferenceModule
import com.zesthra.persona.factory.module.RoomModule
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