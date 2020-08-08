
package com.zesthra.persona

import android.app.Application
import com.zesthra.persona.factory.component.DaggerPersonaComponent
import com.zesthra.persona.factory.component.PersonaComponent
import com.zesthra.persona.factory.module.AppModule
import com.zesthra.persona.factory.module.PreferenceModule
import com.zesthra.persona.factory.module.RoomModule

class Persona : Application() {
    private var personaComponent: PersonaComponent? = null

    override fun onCreate() {
        super.onCreate()
        personaComponent = DaggerPersonaComponent
            .builder()
            .appModule(AppModule(this))
            .roomModule(RoomModule(this))
            .preferenceModule(PreferenceModule(this.applicationContext))
            .build();

    }
    fun getPersonaComponent(): PersonaComponent? {
        return personaComponent
    }



}