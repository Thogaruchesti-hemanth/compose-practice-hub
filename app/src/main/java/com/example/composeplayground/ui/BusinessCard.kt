package com.example.composeplayground.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.R

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCard() {
    val image = painterResource(R.drawable.ic_profile_pic)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green.copy(alpha = 0.3f))
    ) {
        Image(
            painter = image,
            contentDescription = null,
            Modifier
                .padding(0.dp, 250.dp, 0.dp, 0.dp)
        )
        Text(
            text = "Developer08",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(
            modifier = Modifier
                .height(150.dp)
        )
        AddInfo(android.R.drawable.ic_menu_call, "+91 9876543210")
        AddInfo(android.R.drawable.ic_menu_share, "+91 9876543210")
        AddInfo(android.R.drawable.sym_action_email, "+91 9876543210")

    }
}

@Composable
fun AddInfo(icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(20.dp, 0.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier =
                Modifier
                    .padding(10.dp)
                    .size(30.dp),
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
        )
    }
}
