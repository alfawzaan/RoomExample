package com.fawzaan.roomexample.db

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.Executors

class NoteRepository {

    private var noteDao:NoteDao? = null
    private  var noteList: LiveData<List<Note>>? = null

    constructor(application: Application){
        var noteDatabase: NoteDatabase = NoteDatabase.getInstance(application)
        noteDao = noteDatabase.noteDao()
        noteList = noteDao?.selectAll()
    }

    fun insert(note: Note){
        Executors.newFixedThreadPool(4).execute {
            noteDao?.insert(note)
        }
    }

    fun update(note: Note){
        Executors.newFixedThreadPool(4).execute {
            noteDao?.update(note)
        }
    }
    fun delete(note: Note){
        Executors.newFixedThreadPool(4).execute {
            noteDao?.delete(note)
        }
    }
    fun deleteAll(){
        Executors.newFixedThreadPool(4).execute {
            noteDao?.deleteAll()
        }
    }

    fun getNoteList():LiveData<List<Note>>{
        return noteList!!
    }

}