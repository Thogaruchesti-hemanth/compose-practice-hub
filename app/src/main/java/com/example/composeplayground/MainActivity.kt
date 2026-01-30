package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.ComposeTestTheme
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.coerceAtLeast
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp() {
    var shouldShowOnboarding by rememberSaveable() { mutableStateOf(true) }

    if(shouldShowOnboarding) {
        OnboardingScreen(onContinuedClicked = { shouldShowOnboarding = false } )
    } else {
        Greetings()
    }
}

@Composable
fun OnboardingScreen(onContinuedClicked: () -> Unit,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to Basic Codelab!")
        Spacer(Modifier.height(10.dp))
        Button(onClick = onContinuedClicked) {
            Text("Continued")
        }
    }
}

@Composable
fun Greetings(names: List<String> = List(1000) { "$it"}) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 4.dp)
    ) {
        items( items = names) { name ->
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded by remember {mutableStateOf(false)}
    val extraPadding by animateDpAsState(
        targetValue =  if(expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            Spring.StiffnessLow
        )
    )
    Surface(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp),
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(8.dp),
        tonalElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text("Hello,")
                Text(name,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.ExtraBold
                )
                if(expanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +"" +
                                "\n"+
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }
            IconButton(onClick = { expanded = !expanded}) {
                Icon(
                    imageVector = if(expanded) Filled.ExpandLess else Filled.ExpandMore,
                    modifier = Modifier
                        .size(30.dp),
                    contentDescription = null
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewOnBoardingScreen() {
    OnboardingScreen(onContinuedClicked = {})
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewGreetings() {
    Greetings()
}