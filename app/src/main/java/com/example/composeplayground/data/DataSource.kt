package com.example.composeplayground.data

import com.example.composeplayground.R

class DataSource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1,R.drawable.image01),
            Affirmation(R.string.affirmation2,R.drawable.image02),
            Affirmation(R.string.affirmation3,R.drawable.image03),
            Affirmation(R.string.affirmation4,R.drawable.image04),
            Affirmation(R.string.affirmation5,R.drawable.image05),
            Affirmation(R.string.affirmation6,R.drawable.image06),
            Affirmation(R.string.affirmation7,R.drawable.image07),
            Affirmation(R.string.affirmation8,R.drawable.image08),
            Affirmation(R.string.affirmation9,R.drawable.image09),
            Affirmation(R.string.affirmation10,R.drawable.image10),
        )
    }
}