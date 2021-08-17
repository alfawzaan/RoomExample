package com.fawzaan.roomexample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fawzaan.roomexample.db.Note
import com.fawzaan.roomexample.db.NoteViewModel


class MainActivity : AppCompatActivity() {

    var noteViewModel: NoteViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        noteViewModel?.getNoteList()?.observe(this,
            { it ->
                Log.i("No ", "\n\n===========DB STARTING===============")
                Log.i("No ", "=====================================")
                it.forEach {
                    Log.i("No ${it.id}:", "title: ${it.noteTitle} description: ${it.noteDescription}\n")
                }
                Log.i("No ", "===================================")
                Log.i("No ", "=============DB ENDING=============\n\n")
            })

        findViewById<Button>(R.id.button_save).setOnClickListener {
            val noteTitle = findViewById<EditText>(R.id.edit_text_title).text.toString()
            val noteDesc = findViewById<EditText>(R.id.edit_text_description).text.toString()
            noteViewModel?.insert(
                Note(noteTitle, noteDesc)
            )
            findViewById<EditText>(R.id.edit_text_title).setText("")
            findViewById<EditText>(R.id.edit_text_description).setText("")
			Toast.makeText(this, "Note Saved!", Toast.LENGTH_LONG).show()

        }
    }


}