package com.spookybrain.roomexample

class NoteRepository(
    private val db: NoteDatabase = DatabaseFactory.instance.db
) {
    suspend fun getNotes(): List<Note> {
        return db.noteDao().getNotes().map { it.asModel() }
    }

    suspend fun getNoteById(id: Long): Note? {
        return db.noteDao().getNoteById(id)?.asModel()
    }

    suspend fun insertNote(note: Note) {
        db.noteDao().insertNote(note.asEntity())
    }

    suspend fun deleteNote(id: Long) {
        db.noteDao().deleteNote(id)
    }
}