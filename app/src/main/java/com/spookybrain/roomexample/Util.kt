package com.spookybrain.roomexample

fun Note.asEntity() = NoteEntity(id, title, content, created)

fun NoteEntity.asModel() = Note(id, title, content, created)