package com.example.composeplayground.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.EmojiEmotions
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.SentimentSatisfied
import androidx.compose.material.icons.rounded.SupervisedUserCircle
import com.example.composeplayground.models.RecentMessage

val dummyRecents = listOf(
    RecentMessage(
        1,
        "Max Hall",
        "Hello Friend! How are you?",
        "08:30 pm",
        true,
        Icons.Rounded.Person
    ),
    RecentMessage(2, "Dan Martin", "Hi man! Do you know?...", "04:12 pm", true, Icons.Rounded.Face),
    RecentMessage(
        3,
        "Stephen Green",
        "Yes! I like it!",
        "02:05 pm",
        true,
        Icons.Rounded.EmojiEmotions
    ),
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