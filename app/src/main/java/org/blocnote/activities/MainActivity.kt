package org.blocnote.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.blocnote.R
import org.blocnote.adapter.NoteAdapter
import org.blocnote.model.Note

class MainActivity : AppCompatActivity() {
    lateinit var notes: MutableList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_notes)
        notes = mutableListOf()
        notes.add(Note("Titre note 1", "Contenu note 1",0,""))
        notes.add(Note("Titre note 2", "In Kotlin, the lateinit modifier is used for properties (variables) and is specifically designed to address scenarios",1,""))
        notes.add(Note("Titre note 3", "Here's an example in Java to illustrate the concept in Kotlin:",2,""))
        notes.add(Note("Titre note 4", "public void initializeNotes()",3,""))
        notes.add(Note("Titre note 5", "Check assignColor(cat):",4,""))
        notes.add(Note("Titre note 6", " override fun onCreateViewHolder(",5,""))
        notes.add(Note("Titre note 7", "  override fun onBindViewHolder(holder: ViewHolder, position: Int) {\n" +
                "        if (3*position<listOfNotes.size) {",7,""))
        notes.add(Note("Titre note 8", "val noteContent1 = listOfNotes[3*position].contenu\n" +
                "            val filename1 = listOfNotes[3*position].fileName",6,""))
        notes.add(Note("Titre note 9", "Contenu note 9",1,""))
        notes.add(Note("Titre note 10", "Contenu note 10",0,""))

        val noteAdapter = NoteAdapter(notes)
        val recyclerView = findViewById<RecyclerView>(R.id.mainRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = noteAdapter
    }

    fun editNote(position: Int) {
        val intent = Intent(this, DetailNote::class.java)
        intent.putExtra("note", notes[position])
        intent.putExtra("noteindex", position)
        startActivityForResult(intent, DetailNote.REQUEST_EDIT_NOTE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    }
