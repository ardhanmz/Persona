package com.zesthra.persona.data.db.datasource

import com.zesthra.persona.data.db.dataaccess.UserDao
import javax.inject.Inject

class UserDataSource @Inject constructor(val userdao :UserDao? ){

//    override fun findById(username: String): User? {
//        return userdao?.findByUsername(username)
//    }
//
//    override fun findAll(): LiveData<List<User?>?>? {
//        return userdao?.findByAll()
//    }
//
//    override suspend fun insert(user: User) {
//        return userdao?.insert(user)!!
//    }
//
//
//    override fun update(user: User){
//        return userdao?.updateUser(user)!!
//    }
//
//    override fun delete(user: User){
//        return userdao?.deleteUser(user)!!
//    }


}