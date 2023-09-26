package com.spookybrain.roomexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: NoteRepository = NoteRepository()
) {
    private val dispatcher = CoroutineScope(Dispatchers.IO)
    private val _state: MutableLiveData<List<Note>> = MutableLiveData(emptyList())
    val state: LiveData<List<Note>>
        get() = _state

    fun getNotes() {
        dispatcher.launch {
            val result = repository.getNotes()
            _state.postValue(result)
        }
    }

    fun deleteNote(id: Long) {
        dispatcher.launch {
            repository.deleteNote(id)
            getNotes()
        }
    }
}