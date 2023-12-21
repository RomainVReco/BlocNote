package org.blocnote.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.blocnote.R
import org.blocnote.model.Note

class NoteAdapter (private val listOfNotes: List<Note>, private val itemClickListener: OnItemClickListener):
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

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
        return listOfNotes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = listOfNotes.get(position)
        holder.titleNote1.setText(note.)
    }
}