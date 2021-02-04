package com.zesthra.persona.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zesthra.persona.data.db.dataaccess.UserDao
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.db.migration.MigrationV1toV2

@Database(
    entities = [User::class],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "Persona"
            )/*addMigrations(MigrationV1toV2().MIGRATION_1_2)*/.build()
    }

}