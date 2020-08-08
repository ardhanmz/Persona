package com.zesthra.persona.factory.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides


@Module
class PreferenceModule constructor(val contexts: Context) {
    private val context: Context = contexts

    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }

}