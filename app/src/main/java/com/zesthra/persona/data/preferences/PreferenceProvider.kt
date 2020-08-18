package com.zesthra.persona.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.zesthra.persona.utils.Global


class PreferenceProvider(
context: Context
) {

    private val appContext = context.applicationContext

    private val preference: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(appContext)


    fun saveUIMode(boolean: Boolean) {
        preference.edit().putBoolean(
            Global.ui_mode,
            boolean
        ).apply()
    }

    fun getUIMode(): Boolean? {
        return preference.getBoolean(Global.ui_mode, false)
    }

    fun saveFreshInstall(boolean: Boolean) {
        preference.edit().putBoolean(
            Global.fresh_install,
            boolean
        ).apply()
    }

    fun getFreshInstall(): Boolean? {
        return preference.getBoolean(Global.fresh_install, false)
    }

}