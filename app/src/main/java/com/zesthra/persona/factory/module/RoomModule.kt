package com.zesthra.persona.factory.module

import android.app.Application
import dagger.Module


@Module
class RoomModule constructor(val application: Application?){
//
//    private var appDatabase: AppDatabase =  Room.databaseBuilder(application!!, AppDatabase::class.java, "persona").build()
//
//    @Singleton
//    @Provides
//    fun providesRoomDatabase(): AppDatabase {
//        return appDatabase
//    }
//
//    @Singleton
//    @Provides
//    fun providesUserDao(appDatabase: AppDatabase): UserDao? {
//        return appDatabase.getUserDao()
//    }
//
//    @Singleton
//    @Provides
//    fun productRepository(userDao: UserDao?): UserRepository? {
//        return UserDataSource(userDao)
//    }
//
//    @Provides
//    fun provideUserViewModelFactory(repository: UserDataSource): ViewModelProvider.Factory {
//        return UserCustomViewModelFactory(repository)
//    }

}