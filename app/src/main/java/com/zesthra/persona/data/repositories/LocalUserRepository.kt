package com.zesthra.persona.data.repositories

import com.zesthra.persona.data.db.AppDatabase
import com.zesthra.persona.data.db.entities.User

class LocalUserRepository(
    val appDatabase: AppDatabase
) {
    fun findByUsername(username: String) = appDatabase.getUserDao().findByUsername(username)

    fun findAll() = appDatabase.getUserDao().findByAll()

    suspend fun insertUser(user: User) = appDatabase.getUserDao().insert(user)

    suspend fun deleteUser(user: User) = appDatabase.getUserDao().deleteUser(user)
    suspend fun updateUser(user: User) = appDatabase.getUserDao().updateUser(user)

}