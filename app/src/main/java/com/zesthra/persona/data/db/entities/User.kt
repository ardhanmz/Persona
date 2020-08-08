package com.zesthra.persona.data.db.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "username")
    var username : String,
    @ColumnInfo(name ="pincode")
    var pincode : Int
){

}