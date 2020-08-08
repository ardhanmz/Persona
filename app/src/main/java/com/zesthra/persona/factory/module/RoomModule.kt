package com.zesthra.persona.factory.module

import android.app.Application
import android.service.autofill.UserData
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.zesthra.persona.data.db.AppDatabase
import com.zesthra.persona.data.db.dataaccess.UserDao
import com.zesthra.persona.data.db.datasource.UserDataSource
import com.zesthra.persona.data.repositories.UserRepository
import com.zesthra.persona.ui.splashscreen.helloUI.HelloLandingViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule constructor(val application: Application?){

    private var appDatabase: AppDatabase =  Room.databaseBuilder(application!!, AppDatabase::class.java, "persona").build()

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }

    @Singleton
    @Provides
    fun providesUserDao(appDatabase: AppDatabase): UserDao? {
        return appDatabase.getUserDao()
    }

    @Singleton
    @Provides
    fun productRepository(userDao: UserDao?): UserRepository? {
        return UserDataSource(userDao)
    }

    @Provides
    @Singleton
    fun provideViewModelFactory(repository: UserDataSource): ViewModelProvider.Factory {
        return HelloLandingViewModelFactory(repository)
    }

}