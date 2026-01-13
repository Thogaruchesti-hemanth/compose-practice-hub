package com.example.composeplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.components.AddSpace
import com.example.composeplayground.ui.theme.AppTypography

@Preview(showBackground = true)
@Composable
fun TextPracticeScreenThree() {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            text = "Display Large Text",
            style = AppTypography.displayMedium
        )
        Text(
            text = "Headline Medium Text",
            style = AppTypography.headlineMedium
        )
        Text(
            text = "Body small text",
            style = AppTypography.bodySmall,
            color = Color.Gray
        )
        AddSpace(20.dp)

        Text(
            text = "Thin Font Weight",
            fontWeight = FontWeight.Thin
        )
        Text(
            text = "Light Font Weight",
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Medium Font Weight",
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Extra Bold Font Weight",
            fontWeight = FontWeight.ExtraBold
        )
        AddSpace(20.dp)

        Text(
            text = "Primary Emphasis Text",
        )
        Text(
            text = "Secondary Subtle Text",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Text(
            text = "Error Or Alert Text",
            color = Color.Red
        )
        AddSpace(20.dp)
        Text(
            text = "Left Aligned (start)",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Text(
            text = "Center Aligned",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Right Aligned (End)",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )
        AddSpace(20.dp)
        Text(
            text = "This paragraph demonstrates the line height and max lines property. When text text is too long to fit into a single line,we can control how the user perceives the continuation.",
            fontSize = 14.sp,
        )
        AddSpace(10.dp)
        Text(
            text = "This text is forced into one single line and will be and no multiple lines and max lines property",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        AddSpace(20.dp)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "label Left",
                color = Color.Gray
            )
            Text(
                text = "Value Right",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}