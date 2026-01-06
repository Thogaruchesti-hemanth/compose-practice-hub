package com.example.composeplayground.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),   // Chips, small buttons
    small = RoundedCornerShape(8.dp),        // Buttons, cards
    medium = RoundedCornerShape(12.dp),      // Cards, dialogs
    large = RoundedCornerShape(16.dp),       // Sheets, large surfaces
    extraLarge = RoundedCornerShape(28.dp)   // Bottom sheets, full surfaces
)