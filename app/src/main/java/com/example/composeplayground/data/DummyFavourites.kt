package com.example.composeplayground.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.SentimentSatisfied
import androidx.compose.material.icons.rounded.SupervisedUserCircle
import com.example.composeplayground.models.RecentMessage

val dummyFavorites = listOf(
    RecentMessage(
        4,
        "Sarah Woodman",
        "How about my work?",
        "Yesterday",
        false,
        Icons.Rounded.SentimentSatisfied
    ),
    RecentMessage(5, "Peter Hopper", "At 5 pm", "01.22.201", false, Icons.Rounded.AccountCircle),
    RecentMessage(
        6,
        "Denis Ivanov",
        "Oh, no! Are you sure?",
        "01.16.201",
        false,
        Icons.Rounded.SupervisedUserCircle
    ),
    RecentMessage(7, "Alice Silver", "Hello Alex!", "01.12.201", false, Icons.Rounded.Face),
)
