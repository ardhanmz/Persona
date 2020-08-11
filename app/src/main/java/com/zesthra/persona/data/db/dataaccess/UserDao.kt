package com.zesthra.persona.data.db.dataaccess

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zesthra.persona.data.db.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM USER")
    fun findByAll() :  LiveData<List<User?>?>?

    @Query("SELECT * FROM USER WHERE username = :username")
    fun findByUsername(username: String) : User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Delete()
    suspend fun deleteUser(user: User)

    @Update()
    suspend fun updateUser(user: User)
}