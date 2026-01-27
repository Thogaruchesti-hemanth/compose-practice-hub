package com.example.composeplayground

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.models.ChatMessage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MessageBubble(msg: ChatMessage, index: Int) {
    val startOffsetX = if (msg.isFromMe) 200f else -200f
    val slideAnim = remember { Animatable(startOffsetX) }
    val alphaAnim = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        // Delay helps content appear after shared transition settles
        delay(index * 100L + 300L)
        launch {
            slideAnim.animateTo(
                targetValue = 0f,
                animationSpec = spring(
                    dampingRatio = 0.7f,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
        launch {
            alphaAnim.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 400)
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                this.translationX = slideAnim.value
                this.alpha = alphaAnim.value
            },
        contentAlignment = if (msg.isFromMe) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Column(horizontalAlignment = if (msg.isFromMe) Alignment.End else Alignment.Start) {
            Box(
                modifier = Modifier
                    .widthIn(max = 280.dp)
                    .clip(
                        if (msg.isFromMe) RoundedCornerShape(20.dp, 20.dp, 4.dp, 20.dp)
                        else RoundedCornerShape(20.dp, 20.dp, 20.dp, 4.dp)
                    )
                    .background(if (msg.isFromMe) Color(0xFF6C63FF) else Color(0xFF3E3C4E))
                    .padding(16.dp)
            ) {
                Text(
                    text = msg.text,
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = msg.time,
                color = Color.White.copy(0.4f),
                fontSize = 12.sp
            )
        }
    }
}