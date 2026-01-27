package com.example.composeplayground.models

data class ChatMessage(
    val id: Int,
    val text: String,
    val isFromMe: Boolean,
    val time: String
)