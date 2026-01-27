@file:Suppress("COMPOSE_APPLIER_CALL_MISMATCH")

package com.example.composeplayground

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.example.composeplayground.models.RecentMessage
import kotlinx.coroutines.delay

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun RecentsListShared(
    items: List<RecentMessage>,
    state: LazyListState,
    onChatSelected: (RecentMessage) -> Unit,
    shouldAnimate: Boolean
) {
    BoxWithConstraints {
        val startOffsetX = -maxWidth.value

        LazyColumn(
            state = state,
            contentPadding = PaddingValues(top = 16.dp, bottom = 120.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = items,
                key = { _, item -> item.id } // 🔑 important
            ) { index, item ->

                val alphaAnim = remember { Animatable(if (shouldAnimate) 0f else 1f) }
                val slideAnim = remember { Animatable(if (shouldAnimate) startOffsetX else 0f) }

                LaunchedEffect(shouldAnimate) {
                    if (shouldAnimate) {
                        delay(index * 60L)

                        alphaAnim.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(durationMillis = 400)
                        )

                        slideAnim.animateTo(
                            targetValue = 0f,
                            animationSpec = spring(
                                dampingRatio = 0.8f,
                                stiffness = Spring.StiffnessLow
                            )
                        )
                    } else {
                        // 🔒 ensure stable state when animation disabled
                        alphaAnim.snapTo(1f)
                        slideAnim.snapTo(0f)
                    }
                }

                Box(
                    modifier = Modifier
                        .offset(x = slideAnim.value.dp)
                        .alpha(alphaAnim.value)
                ) {
                    SharedRecentItemRow(
                        item = item,
                        onChatSelected = onChatSelected
                    )
                }
            }
        }
    }
}