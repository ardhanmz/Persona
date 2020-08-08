package com.zesthra.persona.data.db.dataaccess

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zesthra.persona.data.db.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM USER")
    fun getUserList() :  LiveData<List<User?>?>?

    @Query("SELECT * FROM USER")
    fun getUserById() : LiveData<User?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Delete()
    fun deleteUser(user: User)

    @Update()
    fun updateUser(user: User)
}