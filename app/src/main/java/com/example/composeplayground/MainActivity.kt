package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.composeplayground.ui.theme.TextFieldExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldExplorerTheme() {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TextFieldExplorerScreen()
                }
            }
        }
    }
}