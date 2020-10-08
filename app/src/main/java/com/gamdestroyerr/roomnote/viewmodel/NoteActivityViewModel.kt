package com.gamdestroyerr.roomnote.viewmodel

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamdestroyerr.roomnote.model.Note
import com.gamdestroyerr.roomnote.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteActivityViewModel(private val repositoryObject: NoteRepository) : ViewModel() {

    fun saveNote(newNote: Note) = viewModelScope.launch {
        Log.d("tag", "saveNote() is called")
        repositoryObject.addNote(newNote)
    }

    private var imageGet: Bitmap? = null

    fun saveImage(image: Bitmap?) {
        imageGet = image
    }

    fun setImage(): Bitmap? {
        return imageGet
    }

    fun updateNote(existingNote: Note) = viewModelScope.launch {
        repositoryObject.updateNote(existingNote)
    }

    fun deleteNote(existingNote: Note) = viewModelScope.launch {
        repositoryObject.deleteNote(existingNote)
    }

    fun searchNote(query: String): LiveData<List<Note>> {
        return repositoryObject.searchNote(query)
    }

    fun getAllNotes(): LiveData<List<Note>> = repositoryObject.getNote()
}