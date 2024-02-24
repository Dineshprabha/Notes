package com.dineshprabha.notes.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dineshprabha.notes.repository.NoteRepository

class NoteViewModelFactory(
    val application: Application,
    private val noteRepository: NoteRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(application, noteRepository) as T

    }
}