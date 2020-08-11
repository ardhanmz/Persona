package com.zesthra.persona.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

private const val UI_MODE = "DARK_MODE"
private const val FRESH_INSTALL = "FRESH_INSTALL"
class PreferenceProvider(
context: Context
) {

    private val appContext = context.applicationContext

    private val preference: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(appContext)


    fun saveUIMode(boolean: Boolean) {
        preference.edit().putBoolean(
            UI_MODE,
            boolean
        ).apply()
    }

    fun getUIMode(): Boolean? {
        return preference.getBoolean(UI_MODE, false)
    }

    fun saveFreshInstall(boolean: Boolean) {
        preference.edit().putBoolean(
            FRESH_INSTALL,
            boolean
        ).apply()
    }

    fun getFreshInstall(): Boolean? {
        return preference.getBoolean(FRESH_INSTALL, false)
    }

}