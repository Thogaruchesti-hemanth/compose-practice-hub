package com.example.composeplayground.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Preview(showBackground = true)
@Composable
fun PracticeColumnArrangements() {

    Column {

        // -------- Arrangement demos --------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            ArrangementDemo("Space Around", Arrangement.SpaceAround)
            ArrangementDemo("Space Between", Arrangement.SpaceBetween)
            ArrangementDemo("Space Evenly", Arrangement.SpaceEvenly)
            ArrangementDemo("Top", Arrangement.Top)
            ArrangementDemo("Center", Arrangement.Center)
            ArrangementDemo("Bottom", Arrangement.Bottom)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // -------- Weight demo --------
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DemoBoxTwo(
                color = Color.DarkGray.copy(0.3f),
                text = "Column 1",
                height = 50.dp
            )
            DemoBoxTwo(
                color = Color.DarkGray.copy(0.3f),
                text = "Column 2",
                height = 60.dp
            )
            DemoBoxTwo(
                color = Color.DarkGray.copy(0.3f),
                text = "Column 3",
                height = 70.dp
            )
            DemoBoxTwo(
                color = Color.DarkGray.copy(0.3f),
                text = "Column 4",
                height = 80.dp
            )
            DemoBoxTwo(
                color = Color.DarkGray.copy(0.3f),
                text = "Column 5",
                height = 90.dp
            )
            DemoBoxTwo(
                color = Color.DarkGray.copy(0.3f),
                text = "Column 6",
                height = 100.dp
            )
        }
    }
}

@Composable
private fun ArrangementDemo(
    title: String,
    arrangement: Arrangement.Vertical
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Column(
            modifier = Modifier
                .height(260.dp)
                .width(100.dp)
                .background(Color.LightGray)
                .padding(8.dp),
            verticalArrangement = arrangement,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DemoBox(Color.Blue)
            DemoBox(Color.Yellow)
            DemoBox(Color.Green)
        }
    }
}

@Composable
private fun DemoBox(color: Color) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(color)
    )
}

@Composable
private fun DemoBoxTwo(
    color: Color,
    text: String,
    height: Dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text, fontWeight = FontWeight.Medium)
    }
}
