package com.example.composeplayground.data

import com.example.composeplayground.R

data class Topic(
    val imageResourceId: Int,
    val stringResourceId: Int,
    val topicCovered: Int,
    val courseResourceId:Int = R.drawable.ic_grain

)
