package com.dineshprabha.notes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dineshprabha.notes.model.Notes
import com.dineshprabha.notes.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    application: Application,
    private val noteRepository: NoteRepository
) : AndroidViewModel(application){

    fun addNote(notes: Notes) =
        viewModelScope.launch {
            noteRepository.insertNote(notes)
        }

    fun deleteNote(notes: Notes) =
        viewModelScope.launch {
            noteRepository.deleteNote(notes)
        }

    fun updateNote(notes: Notes) =
        viewModelScope.launch {
            noteRepository.updateNote(notes)
        }

    fun getAllNote() = noteRepository.getAllNotes()

    fun searchNote(query : String?) = noteRepository.searchNotes(query)
}