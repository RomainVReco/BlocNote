package org.blocnote.model

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import org.blocnote.activities.DetailNote

class Note (var titre: String?, var contenu: String?,
            var category: Int, var fileName: String?): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titre)
        parcel.writeString(contenu)
        parcel.writeInt(category)
        parcel.writeString(fileName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        val keyNote = "Note"
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }

        fun lauchNoteActivity (note: Note, view: View) {
            val intent = Intent(view.context, DetailNote::class.java)
            intent.putExtra(keyNote, note)
            view.context.startActivity(intent)
        }
    }

}