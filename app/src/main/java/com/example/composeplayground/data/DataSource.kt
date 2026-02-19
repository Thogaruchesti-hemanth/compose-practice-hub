package com.example.composeplayground.data

import com.example.composeplayground.R

class DataSource {

    fun loadCourses(): List<Topic> {
        return listOf(
            Topic(
                imageResourceId = R.drawable.architecture,
                stringResourceId = R.string.architecture,
                topicCovered = 58
            ),
            Topic(
                imageResourceId = R.drawable.automotive,
                stringResourceId = R.string.automotive,
                topicCovered = 23
            ),
            Topic(
                imageResourceId = R.drawable.biology,
                stringResourceId = R.string.biology,
                topicCovered = 65
            ),
            Topic(
                imageResourceId = R.drawable.business,
                stringResourceId = R.string.business,
                topicCovered = 78
            ),
            Topic(
                imageResourceId = R.drawable.crafts,
                stringResourceId = R.string.crafts,
                topicCovered = 121
            ),
            Topic(
                imageResourceId = R.drawable.culinary,
                stringResourceId = R.string.culinary,
                topicCovered = 118
            ),
            Topic(
                imageResourceId = R.drawable.design,
                stringResourceId = R.string.design,
                topicCovered = 423
            ),
            Topic(
                imageResourceId = R.drawable.drawing,
                stringResourceId = R.string.drawing,
                topicCovered = 326
            ),
            Topic(
                imageResourceId = R.drawable.ecology,
                stringResourceId = R.string.ecology,
                topicCovered = 36
            ),
            Topic(
                imageResourceId = R.drawable.engineering,
                stringResourceId = R.string.engineering,
                topicCovered = 63
            ),
            Topic(
                imageResourceId = R.drawable.fashion,
                stringResourceId = R.string.fashion,
                topicCovered = 92
            ),
            Topic(
                imageResourceId = R.drawable.film,
                stringResourceId = R.string.film,
                topicCovered = 165
            ),
            Topic(
                imageResourceId = R.drawable.finance,
                stringResourceId = R.string.finance,
                topicCovered = 15
            ),
            Topic(
                imageResourceId = R.drawable.gaming,
                stringResourceId = R.string.gaming,
                topicCovered = 164
            ),
            Topic(
                imageResourceId = R.drawable.geology,
                stringResourceId = R.string.geology,
                topicCovered = 35
            ),
            Topic(
                imageResourceId = R.drawable.history,
                stringResourceId = R.string.history,
                topicCovered = 53
            ),
            Topic(
                imageResourceId = R.drawable.journalism,
                stringResourceId = R.string.journalism,
                topicCovered = 53
            ),
            Topic(
                imageResourceId = R.drawable.law,
                stringResourceId = R.string.law,
                topicCovered = 53
            ),
            Topic(
                imageResourceId = R.drawable.lifestyle,
                stringResourceId = R.string.lifestyle,
                topicCovered = 305
            ),
            Topic(
                imageResourceId = R.drawable.music,
                stringResourceId = R.string.music,
                topicCovered = 212
            ),
            Topic(
                imageResourceId = R.drawable.painting,
                stringResourceId = R.string.painting,
                topicCovered = 172
            ),
            Topic(
                imageResourceId = R.drawable.photography,
                stringResourceId = R.string.photography,
                topicCovered = 321
            ),
            Topic(
                imageResourceId = R.drawable.physics,
                stringResourceId = R.string.physics,
                topicCovered = 321
            ),

            Topic(
                imageResourceId = R.drawable.tech,
                stringResourceId = R.string.tech,
                topicCovered = 118
            )
        )
    }
}