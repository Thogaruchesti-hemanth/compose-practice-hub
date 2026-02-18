package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.ComposeTestTheme

data class Artwork(
    val imageRes: Int,
    val title: String,
    val artist: String,
    val year: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ArtSpaceScreen() // Was empty before — nothing would show
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    val artworks = listOf(
        Artwork(R.drawable.image_1, "Evening in Montmartre", "Edward Hopper", "(1928)"),
        Artwork(R.drawable.image_2, "Valley of the Yosemite", "Albert Bier", "(1864)"),
        Artwork(R.drawable.image_3, "The Enchanted Garden", "John William Waterhouse", "(1916)"),
        Artwork(R.drawable.image_4, "The Iron Giant", "Syd Mead", "(1994)")
    )

    var index by remember { mutableStateOf(0) }
    val selected = /*artworks[index]*/ when (index) {
        0 -> artworks.get(0)
        1 -> artworks.get(1)
        2 -> artworks.get(2)
        3 -> artworks.get(3)
        else -> artworks.get(0)
    }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val isWideScreen = screenWidth > 600.dp
    val contentWidth: Dp = if (isWideScreen) 560.dp else screenWidth - 40.dp


    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .width(contentWidth)
                .padding(20.dp)
        ) {
            Spacer(Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Image(
                    painter = painterResource(selected.imageRes),
                    contentDescription = selected.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                )
            }

            Spacer(Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = selected.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("${selected.artist} ")
                            }
                            append(selected.year)
                        },
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { if (index > 0) index--},
                    enabled = index > 0,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.width(130.dp)
                ) {
                    Text("Previous")
                }
                Button(
                    onClick = { if (index < artworks.lastIndex) index++ },
                    enabled = index < artworks.lastIndex,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.width(130.dp)
                ) {
                    Text("Next")
                }
            }

            Spacer(Modifier.height(8.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
        ArtSpaceScreen()
    }
}