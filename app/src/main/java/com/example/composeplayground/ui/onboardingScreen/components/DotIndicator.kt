package com.example.composeplayground.ui.onboardingScreen.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalDots) { index ->
            val size by animateDpAsState(
                targetValue = if (index == selectedIndex) 10.dp else 8.dp,
                label = "dot_size"
            )

            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(size)
                    .background(
                        color = if (index == selectedIndex)
                            Color(0xFFE64A19)
                        else
                            Color.LightGray,
                        shape = CircleShape
                    )
            )
        }
    }
}