package com.example.composeplayground

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.data.chatDummyData
import com.example.composeplayground.models.RecentMessage

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ChatDetailScreen(
    user: RecentMessage,
    onBack: () -> Unit
) {
    // Safe unwrap of scopes. If null, the screen still renders, just without shared transitions.
    val sharedTransitionScope = LocalSharedTransitionScope.current ?: return
    val animatedVisibilityScope = LocalAnimatedVisibilityScope.current ?: return

    val screenColor = Color(0xFF1C1B2A)
    val headerColor = Color(0xFF2B2939)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(screenColor)
    ) {
        // --- Header ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(headerColor)
                .statusBarsPadding()
                .height(70.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(8.dp))

            // SHARED ELEMENT: AVATAR
            with(sharedTransitionScope) {
                Box(
                    modifier = Modifier
                        .sharedElement(
                            state = rememberSharedContentState(key = "avatar-${user.id}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ -> playfulSpring }
                        )
                        .size(40.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF3E3C4E)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = user.icon,
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.8f),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // SHARED ELEMENT: NAME
            // Note: We use `sharedBounds` + `scaleToBounds` here.
            // This prevents the text from re-flowing (wrapping) as it animates, ensuring
            // the surname doesn't disappear during the transition.
            with(sharedTransitionScope) {
                Text(
                    text = user.name,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    maxLines = 1,
                    modifier = Modifier.sharedBounds(
                        sharedContentState = rememberSharedContentState(key = "name-${user.id}"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        boundsTransform = { _, _ -> playfulSpring },
                        resizeMode = SharedTransitionScope.ResizeMode.ScaleToBounds(
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart
                        )
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.padding(end = 16.dp)
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Menu",
                tint = Color.White,
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        // --- Chat Content ---
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(chatDummyData) { index, msg ->
                MessageBubble(msg = msg, index = index)
            }
        }

        // --- Input Bar ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp)
                .background(Color(0xFF2B2939), RoundedCornerShape(28.dp))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AttachFile,
                contentDescription = "Attach",
                tint = Color.White.copy(0.5f)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Write",
                color = Color.White.copy(0.3f),
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF6C63FF), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Send",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}