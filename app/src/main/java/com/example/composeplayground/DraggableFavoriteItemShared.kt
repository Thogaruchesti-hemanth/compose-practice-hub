package com.example.composeplayground

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.composeplayground.models.RecentMessage
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun DraggableFavoriteItemShared(
    item: RecentMessage,
    onDelete: () -> Unit,
    onChatSelected: (RecentMessage) -> Unit
) {
    val density = LocalDensity.current
    val revealSizeDp = 100.dp
    val maxRevealPx = with(density) { -revealSizeDp.toPx() }
    val snapThreshold = maxRevealPx / 2
    val offsetX = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        // Reveal Background
        Box(
            modifier = Modifier
                .width(revealSizeDp)
                .height(72.dp),
            contentAlignment = Alignment.Center
        ) {
            val progress = (offsetX.value / maxRevealPx).coerceIn(0f, 1.2f)
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .scale(progress)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFFF4D86))
                    .clickable { onDelete() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Delete",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        // Draggable Content
        Box(
            modifier = Modifier
                .offset { IntOffset(offsetX.value.roundToInt(), 0) }
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        val newVal = (offsetX.value + delta).coerceIn(maxRevealPx * 1.5f, 0f)
                        scope.launch { offsetX.snapTo(newVal) }
                    },
                    onDragStopped = {
                        val targetOffset = if (offsetX.value < snapThreshold) maxRevealPx else 0f
                        scope.launch {
                            offsetX.animateTo(
                                targetValue = targetOffset,
                                animationSpec = spring(
                                    Spring.DampingRatioMediumBouncy,
                                    Spring.StiffnessLow
                                )
                            )
                        }
                    }
                )
        ) {
            SharedRecentItemRow(item = item, onChatSelected = onChatSelected)
        }
    }
}