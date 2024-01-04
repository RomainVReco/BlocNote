package org.blocnote.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.blocnote.R
import org.blocnote.model.ColorNote
import org.blocnote.model.Note

class NoteAdapter (private val listOfNotes: List<Note>):
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    val Tag: String = "NOTEADAPTER"
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardView1 = itemView.findViewById<CardView>(R.id.noteCardView1)
        val cardView2 = itemView.findViewById<CardView>(R.id.noteCardView2)
        val cardView3 = itemView.findViewById<CardView>(R.id.noteCardView3)

        val titleNote1 = itemView.findViewById<TextView>(R.id.noteTitle1)
        val titleNote2 = itemView.findViewById<TextView>(R.id.noteTitle2)
        val titleNote3 = itemView.findViewById<TextView>(R.id.noteTitle3)

        var noteContent1 = itemView.findViewById<TextView>(R.id.noteContent1)
        var noteContent2 = itemView.findViewById<TextView>(R.id.noteContent2)
        var noteContent3 = itemView.findViewById<TextView>(R.id.noteContent3)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewitem = inflater.inflate(R.layout.item_reycler_view, parent, false)
        return ViewHolder(viewitem)
    }

    override fun getItemCount(): Int {
        return  if (listOfNotes.size%3 == 0) (listOfNotes.size/3) else listOfNotes.size/3+1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val inlinePosCardOne = 3*position
        val inlinePosCardTwo = 3*position+1
        val inlinePosCardThree = 3*position+2

        if (3*position<listOfNotes.size) {
            val titre1 = listOfNotes[inlinePosCardOne].titre
            val noteContent1 = listOfNotes[inlinePosCardOne].contenu
            val filename1 = listOfNotes[inlinePosCardOne].fileName
            val cat = listOfNotes[inlinePosCardOne].category
            holder.titleNote1.text = titre1
            holder.noteContent1.text = noteContent1
            holder.cardView1.setCardBackgroundColor(assignColor(cat))
            holder.cardView1.tag = "${filename1};${inlinePosCardOne}"
            holder.cardView1.setOnClickListener{ view ->
                Note.lauchNoteActivity(listOfNotes[inlinePosCardOne], view)
            }

            holder.cardView1.visibility = View.VISIBLE
        }

        if (3*position+1 < listOfNotes.size) {
            holder.titleNote2.text = listOfNotes[inlinePosCardTwo].titre
            holder.noteContent2.text = listOfNotes[inlinePosCardTwo].contenu
            holder.cardView2.setCardBackgroundColor(assignColor(listOfNotes[inlinePosCardTwo].category))
            holder.cardView2.tag = "${listOfNotes[inlinePosCardTwo].fileName};${inlinePosCardTwo}"
            holder.cardView2.setOnClickListener{ view ->
                Note.lauchNoteActivity(listOfNotes[inlinePosCardTwo], view)
            }

            holder.cardView2.visibility = View.VISIBLE
        }
        else {
            holder.titleNote2.text = ""
            holder.noteContent2.text = ""
            holder.cardView2.tag = ""
            holder.cardView2.visibility = View.INVISIBLE
        }

        if (3*position+2 < listOfNotes.size) {
            holder.titleNote3.text = listOfNotes[inlinePosCardThree].titre
            holder.noteContent3.text = listOfNotes[inlinePosCardThree].contenu
            holder.cardView3.setCardBackgroundColor(assignColor(listOfNotes[inlinePosCardThree].category))
            holder.cardView3.tag = "${listOfNotes[inlinePosCardThree].fileName};${inlinePosCardThree}"
            holder.cardView3.setOnClickListener{ view ->
                Note.lauchNoteActivity(listOfNotes[inlinePosCardThree], view)
            }
            holder.cardView3.visibility = View.VISIBLE
        }
        else {
            holder.titleNote3.text = ""
            holder.noteContent3.text = ""
            holder.cardView3.tag = ""
            holder.cardView3.visibility = View.INVISIBLE
        }
    }
    private fun assignColor(category: Int): Int {
        when (category) {
            0 -> return ColorNote.AZURIN.color
            1 -> return ColorNote.BLANC.color
            2 -> return ColorNote.CITROUILLE.color
            3 -> return ColorNote.GRIS.color
            4 -> return ColorNote.JAUNE.color
            5 -> return ColorNote.ROSE.color
            6 -> return ColorNote.VERT.color
            else -> return ColorNote.NOIR.color
        }
    }
}