package com.example.composeplayground.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.AppTypography
import com.example.composeplayground.ui.theme.md_theme_light_outline

@Composable
fun TitleText(title: String) {
    AddSpace(10.dp)
    Text(
        text = title,
        style = AppTypography.headlineSmall,
        color = md_theme_light_outline,
        textAlign = TextAlign.Start
    )
    AddSpace(5.dp)
}


@Composable
fun AddSpace(height: Dp){
    Spacer(modifier = Modifier.height(height))
}