package com.zesthra.persona.utils

import android.content.ContentValues.TAG
import android.util.Log

object HelperClass {
    fun logErrorMessage(errorMessage: String?) {
        Log.d(TAG, errorMessage!!)
    }
}