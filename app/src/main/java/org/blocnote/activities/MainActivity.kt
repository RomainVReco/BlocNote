package org.blocnote.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.blocnote.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.liste_notes)
    }
}