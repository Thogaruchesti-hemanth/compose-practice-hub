package com.example.composeplayground

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.models.RecentMessage

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedRecentItemRow(
    item: RecentMessage,
    onChatSelected: (RecentMessage) -> Unit
) {
    // Safe Scope Access: We render the item even if shared transitions aren't active.
    val sharedTransitionScope = LocalSharedTransitionScope.current
    val animatedVisibilityScope = LocalAnimatedVisibilityScope.current

    val cardColor = Color(0xFF2B2939)
    // Custom interaction source to disable ripple effect
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(cardColor, RoundedCornerShape(18.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null // Ripple Removed
            ) { onChatSelected(item) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // AVATAR (Shared Element)
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(Color(0xFF3E3C4E))
                .then(
                    if (sharedTransitionScope != null && animatedVisibilityScope != null) {
                        with(sharedTransitionScope) {
                            Modifier.sharedElement(
                                state = rememberSharedContentState(key = "avatar-${item.id}"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ -> playfulSpring }
                            )
                        }
                    } else Modifier
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.size(28.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            // NAME (Shared Bounds + ScaleToBounds)
            Text(
                text = item.name,
                style = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,
                modifier = Modifier.then(
                    if (sharedTransitionScope != null && animatedVisibilityScope != null) {
                        with(sharedTransitionScope) {
                            Modifier.sharedBounds(
                                sharedContentState = rememberSharedContentState(key = "name-${item.id}"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ -> playfulSpring },
                                resizeMode = SharedTransitionScope.ResizeMode.ScaleToBounds(
                                    ContentScale.Fit,
                                    Alignment.CenterStart
                                )
                            )
                        }
                    } else Modifier
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.message,
                style = TextStyle(color = Color.White.copy(0.6f), fontSize = 14.sp),
                maxLines = 1
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(40.dp)
        ) {
            Text(
                text = item.time,
                style = TextStyle(color = Color.White.copy(0.4f), fontSize = 12.sp)
            )
            if (item.isOnline) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color(0xFF2ED3B7), CircleShape)
                )
            }
        }
    }
}