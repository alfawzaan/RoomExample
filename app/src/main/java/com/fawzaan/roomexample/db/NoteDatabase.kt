package com.fawzaan.roomexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao():NoteDao



    companion object{
        private  var instance: NoteDatabase? = null

        @Synchronized
        fun getInstance(mContext: Context):NoteDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(mContext.applicationContext, NoteDatabase::class.java, "note_db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }

}