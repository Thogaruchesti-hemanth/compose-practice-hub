package com.example.composeplayground.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirthdayGreeting(name: String = "hemanth") {
    val image = painterResource(R.drawable.happybirthday)
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter =image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.5f
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 10.dp)
        ) {
            Text(
                text = "Happy Birthday $name!",
                fontSize = 80.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Medium,
                lineHeight = 80.sp,
                color = Color.Black
            )
            Text(
                text = "From Hemanth",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 20.dp),
                textAlign = TextAlign.End
            )

        }
    }
}