package com.example.composeplayground.ui.onboardingScreen

import androidx.annotation.DrawableRes

data class OnboardingPage(
    val title: String,
    val description: String,
    val buttonText: String,
    @field:DrawableRes val image: Int
)
