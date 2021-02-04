package com.zesthra.persona.data.db.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "DTM_CRT")
    var dtm_crt: Long,
    @ColumnInfo(name = "USERNAME")
    var username : String,
    @ColumnInfo(name ="PINCODE")
    var pincode : Int,
    @ColumnInfo(name= "INCOME")
    var income: Int,
)