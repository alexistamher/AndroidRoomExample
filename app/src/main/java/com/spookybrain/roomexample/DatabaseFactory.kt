package com.spookybrain.roomexample

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room

class DatabaseFactory private constructor() {
    lateinit var db: NoteDatabase

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: DatabaseFactory? = null

        @SuppressLint("StaticFieldLeak")
        val instance = INSTANCE ?: synchronized(this) {
            INSTANCE ?: DatabaseFactory().apply {
                INSTANCE = this
            }
        }
    }

    fun setContext(context: Context) {
        db = Room
            .databaseBuilder(context, NoteDatabase::class.java, "notes_db")
            .build()
    }
}