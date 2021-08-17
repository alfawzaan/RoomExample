package com.fawzaan.roomexample.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note {

    @PrimaryKey(autoGenerate = true)
     var id: Int? = null
     var noteTitle:String? = null
     var noteDescription: String? = null

    constructor(noteTitle: String?, noteDescription: String?) {
        this.noteTitle = noteTitle
        this.noteDescription = noteDescription
    }

}