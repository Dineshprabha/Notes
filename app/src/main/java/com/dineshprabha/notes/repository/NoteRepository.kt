package com.dineshprabha.notes.repository

import androidx.room.Query
import com.dineshprabha.notes.database.NoteDatabase
import com.dineshprabha.notes.model.Notes

class NoteRepository(private val noteDatabase: NoteDatabase) {

    suspend fun insertNote(notes: Notes) = noteDatabase.noteDao().insertNote(notes)
    suspend fun updateNote(notes: Notes) = noteDatabase.noteDao().updateNote(notes)
    suspend fun deleteNote(notes: Notes) = noteDatabase.noteDao().deleteNote(notes)

    fun getAllNotes() = noteDatabase.noteDao().getAllNotes()
    fun searchNotes(query: String?) = noteDatabase.noteDao().searchNote(query)
}