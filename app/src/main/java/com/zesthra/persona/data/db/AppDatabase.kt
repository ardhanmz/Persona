package com.zesthra.persona.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zesthra.persona.data.db.dataaccess.UserDao
import com.zesthra.persona.data.db.entities.User

@Database(
    entities = [User::class],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

}