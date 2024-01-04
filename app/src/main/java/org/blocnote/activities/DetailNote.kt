package org.blocnote.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import org.blocnote.R
import org.blocnote.model.ColorNote
import org.blocnote.model.Note

class DetailNote : AppCompatActivity() {
    lateinit var receivedNote: Note
    lateinit var radiogroup: RadioGroup
    val Tag = "DETAILNOTE"
    val listOfCategory: MutableList<String> = mutableListOf("A faire", "Liste de courses", "RDV perso",
        "RDV pro","Lien internet", "Contact", "Loisirs")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_note)
        receivedNote = intent.getParcelableExtra(Note.keyNote)!!
        radiogroup = findViewById(R.id.radioGroup)

        val title = findViewById<TextView>(R.id.detailNoteTitle)
        val content = findViewById<TextView>(R.id.detailNoteContent)
        val category = findViewById<TextView>(R.id.categorie)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarDetail)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        updateDisplayContent(title, content, category)

        updateViewColor(title, content, category)

        category.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            radiogroup.visibility=View.VISIBLE
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_note_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_save -> {
                Toast.makeText(this, "icone save cliqué", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateDisplayContent(title: TextView, content: TextView, category: TextView) {
        title.text = receivedNote.titre
        content.text = receivedNote.contenu
        category.text = listOfCategory[receivedNote.category]
    }

    private fun updateViewColor(title: TextView, content: TextView, category: TextView) {
        title.setBackgroundColor(ColorNote.entries[receivedNote.category].color)
        content.setBackgroundColor(ColorNote.entries[receivedNote.category].color)
        category.setBackgroundColor(ColorNote.entries[receivedNote.category].color)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(Tag, "onRestart")
    }
}