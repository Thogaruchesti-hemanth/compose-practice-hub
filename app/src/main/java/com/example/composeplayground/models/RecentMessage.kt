package com.example.composeplayground.models

import androidx.compose.ui.graphics.vector.ImageVector

data class RecentMessage(
    val id: Int,
    val name: String,
    val message: String,
    val time: String,
    val isOnline: Boolean,
    val icon: ImageVector
)