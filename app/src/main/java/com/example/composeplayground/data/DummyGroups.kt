package com.example.composeplayground.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Brush
import androidx.compose.material.icons.rounded.DirectionsCar
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.SportsEsports
import androidx.compose.material.icons.rounded.Work
import com.example.composeplayground.models.RecentMessage

val dummyGroups = listOf(
    RecentMessage(
        10,
        "Design Team",
        "New mockups are ready!",
        "10:30 am",
        true,
        Icons.Rounded.Brush
    ),
    RecentMessage(
        11,
        "Weekend Trip",
        "Who is bringing the snacks?",
        "09:15 am",
        true,
        Icons.Rounded.DirectionsCar
    ),
    RecentMessage(
        12,
        "Family Group",
        "Mom: Call me when you can",
        "Yesterday",
        false,
        Icons.Rounded.Home
    ),
    RecentMessage(13, "Project Alpha", "Meeting delayed to 4 PM", "Mon", true, Icons.Rounded.Work),
    RecentMessage(14, "Gaming Squad", "Online tonight?", "Sun", false, Icons.Rounded.SportsEsports),
)
