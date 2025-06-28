package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.navigation.PlaygroundNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundApp()
        }
    }
}

@Composable
fun ComposePlaygroundApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    MaterialTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Star, contentDescription = "Button") },
                        label = { Text("Button") },
                        selected = currentDestination == "button_showcase",
                        onClick = { navController.navigate("button_showcase") }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Text") },
                        label = { Text("Text") },
                        selected = currentDestination == "text_showcase",
                        onClick = { navController.navigate("text_showcase") }
                    )
                }
            }
        ) { innerPadding ->
            PlaygroundNavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
