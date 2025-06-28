package com.example.composeplayground.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeplayground.screens.ButtonPlaygroundScreen
import com.example.composeplayground.screens.TextShowcaseScreen

@Composable
fun PlaygroundNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "button_showcase",
        modifier = modifier
    ) {
        composable("button_showcase") {
            ButtonPlaygroundScreen()
        }
        composable("text_showcase") {
            TextShowcaseScreen()
        }
    }
}
