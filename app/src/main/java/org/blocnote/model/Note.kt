package org.blocnote.model

import android.os.Parcel
import android.os.Parcelable

class Note (private val titre: String?, private val contenu: String?,
            private val category: Int, private val fileName: String?): Parcelable {

                val mutableStringList: MutableList<String> = mutableListOf()
    var thisIsMYlist: List<String> = ArrayList()

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
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }

}