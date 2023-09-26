package com.spookybrain.roomexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "created")
    val created: Long
)