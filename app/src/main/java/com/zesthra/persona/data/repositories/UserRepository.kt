package com.zesthra.persona.data.repositories

import androidx.lifecycle.LiveData
import com.zesthra.persona.data.db.entities.User


interface UserRepository {
    fun findById(id: Int): LiveData<User?>?

    fun findAll(): LiveData<List<User?>?>?

    fun insert(user: User)

    fun update(user: User)

    fun delete(user: User)
}