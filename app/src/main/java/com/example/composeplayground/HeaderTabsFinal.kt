package com.example.composeplayground

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.data.dummyFavorites
import com.example.composeplayground.data.dummyGroups
import com.example.composeplayground.data.dummyRecents
import com.example.composeplayground.models.RecentMessage
import com.example.composeplayground.models.TabItem
import kotlinx.coroutines.delay


@Composable
fun HeaderTabsFinal(
    selectedIndex: Int,
    shouldAnimate: Boolean,
    onTabSelected: (Int) -> Unit,
    onChatSelected: (RecentMessage) -> Unit
) {
    // Layout Constants
    val topSpace = 80.dp
    val tabTextStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    val flareWidth = 56.dp
    val flareHeight = 36.dp
    val bottomCornerRadius = 26.dp

    val tabs = listOf(
        TabItem("Recents", Color(0xFF6C63FF)),
        TabItem("Favorites", Color(0xFFFF4D86)),
        TabItem("Groups", Color(0xFF2ED3B7))
    )

    // Animate header background color based on selection
    val headerColor by animateColorAsState(
        targetValue = tabs[selectedIndex].color,
        animationSpec = spring(dampingRatio = 0.75f, stiffness = 200f),
        label = "headerColor"
    )

    val density = LocalDensity.current
    val noRipple = remember { MutableInteractionSource() }

    // Dynamic tab sizing for the indicator
    var tabBounds by remember(tabs.size) { mutableStateOf(List(tabs.size) { Rect.Zero }) }
    val target = tabBounds.getOrNull(selectedIndex) ?: Rect.Zero

    val isFirst = selectedIndex == 0
    val isLast = selectedIndex == tabs.size - 1
    val hasStartFlare = !isFirst
    val hasEndFlare = !isLast

    // Calculate Indicator Position and Width
    val targetX =
        if (hasStartFlare) target.left.toDp(density) - flareWidth else target.left.toDp(density)
    val indicatorX by animateDpAsState(
        targetValue = targetX,
        animationSpec = spring(dampingRatio = 0.75f, stiffness = 200f),
        label = "X"
    )

    val widthAdjustment =
        (if (hasStartFlare) flareWidth else 0.dp) + (if (hasEndFlare) flareWidth else 0.dp)
    val indicatorW by animateDpAsState(
        targetValue = target.width.toDp(density) + widthAdjustment,
        animationSpec = spring(dampingRatio = 0.75f, stiffness = 200f),
        label = "W"
    )

    val screenColor = Color(0xFF1C1B2A)

    // Search Logic
    var isSearchActive by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val maxSearchWidth = screenWidth - 24.dp

    // Playful Search Expansion Animation
    val searchWidthFraction by animateFloatAsState(
        targetValue = if (isSearchActive) 1f else 0f,
        animationSpec = spring(
            dampingRatio = 0.7f, // Jelly-like bounce
            stiffness = 200f     // Smooth speed
        ),
        label = "SearchWidth"
    )

    // Persist scroll states
    val recentsState = rememberSaveable(saver = LazyListState.Saver) { LazyListState() }
    val favoritesState = rememberSaveable(saver = LazyListState.Saver) { LazyListState() }
    val groupsState = rememberSaveable(saver = LazyListState.Saver) { LazyListState() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(screenColor)
    ) {
        // --- Header Section ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(headerColor)
                .statusBarsPadding()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(topSpace)
                    .padding(horizontal = 8.dp)
            ) {
                // Add Button (Left)
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 8.dp)
                        .graphicsLayer {
                            // Shrink add button when search expands
                            val s = 1f - searchWidthFraction
                            scaleX = s
                            scaleY = s
                            alpha = s
                        }
                        .size(60.dp)
                        .clip(CircleShape)
                        .clickable(
                            interactionSource = noRipple,
                            indication = null
                        ) { /* Add Action */ },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.requiredSize(28.dp)
                    )
                }

                // Search Bar (Right)
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .height(60.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    // Background Pill
                    Box(
                        modifier = Modifier
                            .width(maxSearchWidth * searchWidthFraction)
                            .height(50.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(Color.White.copy(alpha = 0.25f))
                    )

                    // Text Field
                    if (searchWidthFraction > 0.1f) {
                        Row(
                            modifier = Modifier
                                .width(maxSearchWidth * searchWidthFraction)
                                .height(50.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 20.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                BasicTextField(
                                    value = searchText,
                                    onValueChange = { searchText = it },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .focusRequester(focusRequester)
                                        .alpha(searchWidthFraction.coerceIn(0f, 1f)),
                                    textStyle = TextStyle(color = Color.White, fontSize = 20.sp),
                                    cursorBrush = SolidColor(Color.White),
                                    singleLine = true,
                                    decorationBox = { innerTextField ->
                                        if (searchText.isEmpty()) {
                                            Text(
                                                text = "Search...",
                                                color = Color.White.copy(0.6f),
                                                fontSize = 20.sp
                                            )
                                        }
                                        innerTextField()
                                    }
                                )
                            }
                            // Spacer to prevent text overlapping button area
                            Spacer(modifier = Modifier.width(60.dp))
                        }
                    }

                    LaunchedEffect(isSearchActive) {
                        if (isSearchActive) {
                            delay(100)
                            focusRequester.requestFocus()
                        }
                    }

                    // Search/Close Icon Button
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .clickable(interactionSource = noRipple, indication = null) {
                                isSearchActive = !isSearchActive
                                if (!isSearchActive) searchText = ""
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        // We use AnimatedContent with Scale+Fade to prevent visual overlapping
                        AnimatedContent(
                            targetState = isSearchActive,
                            transitionSpec = {
                                (scaleIn(animationSpec = tween(300)) + fadeIn(
                                    animationSpec = tween(
                                        300
                                    )
                                ))
                                    .togetherWith(
                                        scaleOut(animationSpec = tween(300)) + fadeOut(
                                            animationSpec = tween(
                                                300
                                            )
                                        )
                                    )
                            },
                            label = "IconAnim"
                        ) { active ->
                            Icon(
                                imageVector = if (active) Icons.Filled.Close else Icons.Filled.Search,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.requiredSize(28.dp)
                            )
                        }
                    }
                }
            }
        }

        // --- Tabs Section ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(screenColor)
        ) {
            // Animated Indicator (The "Gooey" Background)
            if (target.width > 0f) {
                Box(
                    modifier = Modifier
                        .offset(x = indicatorX, y = (-1).dp)
                        .width(indicatorW)
                        .height(57.dp)
                        .background(
                            color = headerColor,
                            shape = getUltraSmoothedEdgesShape(
                                flareWidth = with(density) { flareWidth.toPx() },
                                flareHeight = with(density) { flareHeight.toPx() },
                                cornerSize = with(density) { bottomCornerRadius.toPx() },
                                hasStartFlare = hasStartFlare,
                                hasEndFlare = hasEndFlare
                            )
                        )
                )
            }

            // Tab Text Items
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                tabs.forEachIndexed { index, tab ->
                    val selected = index == selectedIndex
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable(interactionSource = noRipple, indication = null) {
                                onTabSelected(index)
                            }
                            .onGloballyPositioned { coords ->
                                val pos = coords.positionInParent()
                                tabBounds = tabBounds
                                    .toMutableList()
                                    .also { list ->
                                        list[index] = Rect(
                                            pos.x,
                                            pos.y,
                                            pos.x + coords.size.width,
                                            pos.y + coords.size.height
                                        )
                                    }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = tab.title,
                            color = if (selected) Color.White else Color.White.copy(alpha = 0.5f),
                            style = tabTextStyle
                        )
                    }
                }
            }
        }

        // --- Content Section ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(screenColor)
        ) {
            when (selectedIndex) {
                0 -> RecentsListShared(
                    items = dummyRecents,
                    state = recentsState,
                    onChatSelected = onChatSelected,
                    shouldAnimate = shouldAnimate
                )

                1 -> FavoritesListShared(
                    items = dummyFavorites,
                    state = favoritesState,
                    onChatSelected = onChatSelected,
                    shouldAnimate = shouldAnimate
                )

                2 -> GroupsListShared(
                    items = dummyGroups,
                    state = groupsState,
                    onChatSelected = onChatSelected,
                    shouldAnimate = shouldAnimate
                )
            }
            BottomNavBar(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}



