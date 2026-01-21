package com.example.composeplayground.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeplayground.model.DictionaryData
import com.example.composeplayground.model.RetroFitInstance
import kotlinx.coroutines.launch

class DictionaryViewModel : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set

    var wordData by mutableStateOf<DictionaryData?>(null)
        private set

    fun searchWord(word: String) {
        if(word.isBlank()) return

        viewModelScope.launch {
            isLoading = true
            try {
                val response= RetroFitInstance.api.getWordMeaning(word)
                wordData = response.firstOrNull()
            } catch (e: Exception) {
                wordData = null
            }
            isLoading = false
        }
    }
}