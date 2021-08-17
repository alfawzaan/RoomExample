package com.fawzaan.roomexample.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

 class NoteViewModel: AndroidViewModel {

    var noteRepository: NoteRepository? = null
    private var noteList: LiveData<List<Note>>? = null
    public constructor(application: Application) : super(application){

        noteRepository  = NoteRepository(application)
        noteList = noteRepository?.getNoteList()
    }

    fun insert(note: Note){
        noteRepository?.insert(note)
    }

    fun update(note: Note){
        noteRepository?.update(note)
    }

    fun delete(note: Note){
        noteRepository?.delete(note)
    }

    fun deleteAll(){
        noteRepository?.deleteAll()
    }

    fun getNoteList(): LiveData<List<Note>>{
        return noteRepository?.getNoteList()!!
    }
}