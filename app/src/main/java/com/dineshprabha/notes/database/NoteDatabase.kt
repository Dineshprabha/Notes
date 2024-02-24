package com.dineshprabha.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dineshprabha.notes.model.Notes

@Database(entities = [Notes::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao

    companion object{
        @Volatile
        private var instance: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance ?:
            createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "note_db"
            ).build()
    }

}