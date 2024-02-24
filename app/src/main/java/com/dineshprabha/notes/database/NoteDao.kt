package com.dineshprabha.notes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dineshprabha.notes.model.Notes

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(notes: Notes)

    @Delete
    suspend fun deleteNote(notes: Notes)

    @Update
    suspend fun updateNote(notes: Notes)

    @Query("SELECT * FROM NOTES ORDER BY id DESC")
    fun getAllNotes() : LiveData<List<Notes>>

    @Query("SELECT * FROM NOTES WHERE title LIKE :query OR description LIKE :query")
    fun searchNote(query: String?) : LiveData<List<Notes>>
}