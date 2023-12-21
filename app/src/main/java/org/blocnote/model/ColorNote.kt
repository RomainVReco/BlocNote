package org.blocnote.model

import android.graphics.Color

enum class ColorNote (val color: Int) {
    AZURIN(Color.rgb(169, 234, 254)) {
        override fun commentaire() = "Azurin"
    },
    BLANC(Color.rgb(254, 254, 226)) {
        override fun commentaire() = "Blanc cassé"
    },
    CITROUILLE(Color.rgb(223, 109, 20)) {
        override fun commentaire() = "Citrouille"
    },
    GRIS(Color.rgb(239, 239, 239)) {
        override fun commentaire() = "Argile"
    },
    JAUNE(Color.rgb(255, 255, 107)) {
        override fun commentaire() = "Soufre"
    },
    ROSE(Color.rgb(254, 191, 210)) {
        override fun commentaire() = "Rose dragée"
    },
    VERT(Color.rgb(176, 242, 182)) {
        override fun commentaire() = "Vert d'eau"
    };

    abstract fun commentaire(): String

}
