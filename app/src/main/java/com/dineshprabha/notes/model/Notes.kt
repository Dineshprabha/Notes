package com.dineshprabha.notes.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title: String,
    val description:String
):Parcelable
