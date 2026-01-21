package com.example.composeplayground

import DictionaryScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.ui.theme.ComposeTestTheme
import com.example.composeplayground.viewmodel.DictionaryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
               val dictionaryViewModel: DictionaryViewModel = viewModel()
                DictionaryScreen(dictionaryViewModel)
            }
        }
    }
}