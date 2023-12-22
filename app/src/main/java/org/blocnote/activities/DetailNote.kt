package org.blocnote.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import org.blocnote.R
import org.blocnote.model.ColorNote
import org.blocnote.model.Note

class DetailNote : AppCompatActivity() {
    lateinit var receivedNote: Note
    val Tag = "DETAILNOTE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_note)
        receivedNote = intent.getParcelableExtra(Note.keyNote)!!

        val title = findViewById<TextView>(R.id.detailNoteTitle)
        val content = findViewById<TextView>(R.id.detailNoteContent)

        updateDisplayContent(title, content)

        updateViewColor(title, content)

    }

    private fun updateDisplayContent(title: TextView, content: TextView) {
        title.text = receivedNote.titre
        content.text = receivedNote.contenu
    }

    private fun updateViewColor(title: TextView, content: TextView) {
        title.setBackgroundColor(ColorNote.entries[receivedNote.category].color)
        content.setBackgroundColor(ColorNote.entries[receivedNote.category].color)
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