package com.zesthra.persona.data.db.datasource

import androidx.lifecycle.LiveData
import com.zesthra.persona.data.db.dataaccess.UserDao
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.repositories.UserRepository
import javax.inject.Inject

class UserDataSource @Inject constructor(val userdao :UserDao? ) : UserRepository{

    override fun findById(id: Int): LiveData<User?>? {
        return userdao?.getUserById()
    }

    override fun findAll(): LiveData<List<User?>?>? {
        return userdao?.getUserList()
    }

    override fun insert(user: User) {
        return userdao?.insertUser(user)!!
    }

    override fun update(user: User){
        return userdao?.updateUser(user)!!
    }

    override fun delete(user: User){
        return userdao?.deleteUser(user)!!
    }


}