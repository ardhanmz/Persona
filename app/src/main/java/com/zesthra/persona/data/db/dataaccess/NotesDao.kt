package com.zesthra.persona.data.db.dataaccess

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zesthra.persona.data.db.entities.Notes
import com.zesthra.persona.data.db.entities.User

@Dao
interface NotesDao {
    @Query("SELECT * FROM NOTES")
    fun findByAll() :  LiveData<List<Notes?>?>?

//    @Query("SELECT * FROM USER WHERE username = :username")
//    fun findByUsername(username: String) : User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: Notes)

    @Delete()
    suspend fun deleteUser(notes: Notes)

    @Update()
    suspend fun updateUser(notes: Notes)
}