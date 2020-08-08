package com.zesthra.persona.data.preferences

import android.content.SharedPreferences
import javax.inject.Inject


class PreferenceProvider @Inject constructor(private val mSharedPreferences: SharedPreferences) {
    fun putData(key: String?, data: Int) {
        mSharedPreferences.edit().putInt(key, data).apply()
    }

    fun getData(key: String?): Int {
        return mSharedPreferences.getInt(key, 0)
    }

}