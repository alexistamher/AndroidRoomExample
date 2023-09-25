package com.spookybrain.roomexample

import androidx.room.Database
import androidx.room.RoomDatabase

@Database( // defines that this class is a database to the compiler
    entities = [
        // we need to tell to the compiler what entities should account
        NoteEntity::class
    ],
    version = 1 // defines the data base version, this helps on migrations
)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}