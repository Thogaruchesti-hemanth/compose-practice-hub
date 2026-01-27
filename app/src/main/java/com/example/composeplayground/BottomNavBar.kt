package com.example.composeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.ChatBubble
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .shadow(20.dp, RoundedCornerShape(36.dp), spotColor = Color.Black.copy(0.6f))
                .clip(RoundedCornerShape(36.dp))
                .background(Color(0xFF2B2939).copy(alpha = 0.95f))
                .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(36.dp)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF6C63FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ChatBubble,
                        contentDescription = "Chat",
                        tint = Color.White,
                        modifier = Modifier.size(26.dp)
                    )
                }
                Icon(
                    imageVector = Icons.Outlined.Call,
                    contentDescription = "Call",
                    tint = Color.White.copy(0.4f),
                    modifier = Modifier.size(28.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profile",
                    tint = Color.White.copy(0.4f),
                    modifier = Modifier.size(28.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "Settings",
                    tint = Color.White.copy(0.4f),
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}