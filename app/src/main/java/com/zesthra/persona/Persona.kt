
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
//    private var personaComponent: PersonaComponent? = null

    override fun onCreate() {
        super.onCreate()
        //Dagger 2 Init
            /*personaComponent = DaggerPersonaComponent
            .builder()
            .appModule(AppModule(this))
            .roomModule(RoomModule(this))
            .preferenceModule(PreferenceModule(this.applicationContext))
            .build();*/
        //KOIN Init
        startKoin {
            // declare used Android context
            androidContext(this@Persona)
            // declare modules
            modules(AppModule)
        }

    }
//    fun getPersonaComponent(): PersonaComponent? {
//        return personaComponent
//    }



}