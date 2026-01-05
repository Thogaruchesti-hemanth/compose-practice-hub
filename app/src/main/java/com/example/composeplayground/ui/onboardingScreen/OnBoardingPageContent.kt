package com.example.composeplayground.ui.onboardingScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.onboardingScreen.components.DotsIndicator
import com.example.composeplayground.ui.onboardingScreen.components.OnboardingButton
import com.example.composeplayground.ui.onboardingScreen.components.OnboardingImage
import com.example.composeplayground.ui.onboardingScreen.components.OnboardingText


@Composable
fun OnboardingPageContent(
    page: OnboardingPage,
    currentPage: Int,
    totalPages: Int,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        OnboardingImage(image = page.image)
        OnboardingText(
            title = page.title,
            description = page.description,
        )
        DotsIndicator(
            totalDots = totalPages,
            selectedIndex = currentPage
        )
        OnboardingButton(
            text = page.buttonText,
            onClick = onButtonClick
        )
    }
}