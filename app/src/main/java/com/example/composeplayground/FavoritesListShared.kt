package com.example.composeplayground

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.composeplayground.models.RecentMessage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun FavoritesListShared(
    items: List<RecentMessage>,
    state: LazyListState,
    onChatSelected: (RecentMessage) -> Unit,
    shouldAnimate: Boolean
) {
    var favorites by remember { mutableStateOf(items) }

    LazyColumn(
        state = state,
        contentPadding = PaddingValues(top = 16.dp, bottom = 120.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(favorites, key = { _, item -> item.id }) { index, item ->
            val alphaAnim = remember { Animatable(if (shouldAnimate) 0f else 1f) }
            val offsetYAnim = remember { Animatable(if (shouldAnimate) -100f else 0f) }

            if (shouldAnimate) {
                LaunchedEffect(Unit) {
                    delay(index * 100L)
                    launch { alphaAnim.animateTo(1f, tween(500)) }
                    launch {
                        offsetYAnim.animateTo(
                            0f,
                            spring(Spring.DampingRatioMediumBouncy, Spring.StiffnessLow)
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .graphicsLayer {
                        this.alpha = alphaAnim.value
                        this.translationY = offsetYAnim.value.dp.toPx()
                    }
            ) {
                DraggableFavoriteItemShared(
                    item = item,
                    onDelete = {
                        favorites = favorites.toMutableList().also { it.remove(item) }
                    },
                    onChatSelected = onChatSelected
                )
            }
        }
    }
}
