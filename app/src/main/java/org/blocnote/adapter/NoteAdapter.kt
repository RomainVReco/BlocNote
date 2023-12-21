package org.blocnote.adapter

import android.view.View
import android.widget.AdapterView.OnItemClickListener
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.blocnote.R
import org.blocnote.model.Note

class NoteAdapter (private val listOfNotes: List<Note>, private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardView1 = itemView.findViewById<CardView>(R.id.noteCardView1)
        val cardView2 = itemView.findViewById<CardView>(R.id.noteCardView2)
        val cardView3 = itemView.findViewById<CardView>(R.id.noteCardView3)

    }
}