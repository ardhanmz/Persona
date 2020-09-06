package com.zesthra.persona.data.db.entities

import androidx.room.*

@Entity(foreignKeys = arrayOf(
        ForeignKey(entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("uuid_user"),
        onDelete = ForeignKey.CASCADE)
    ),
    indices = arrayOf(
        Index(value = ["uuid_user"])
    )
)
data class Notes (
    @PrimaryKey(autoGenerate = true)
    var uuidNotes: Int,
    @ColumnInfo(name = "uuid_user")
    var uuid_user : Int,
    @ColumnInfo(name = "dtm_crt")
    var dtm_crt : Long,
    @ColumnInfo(name = "dtm_upd")
    var dtm_upd : Long,
    @ColumnInfo(name = "title_notes")
    var title_notes : String,
    @ColumnInfo(name = "body_notes")
    var body_notes : Int,
    @ColumnInfo(name = "color_notes")
    var color_notes : String,
)