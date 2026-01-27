package com.example.composeplayground.models

sealed class Screen {
    data object Home : Screen()
    data class Chat(val user: RecentMessage) : Screen()
}
