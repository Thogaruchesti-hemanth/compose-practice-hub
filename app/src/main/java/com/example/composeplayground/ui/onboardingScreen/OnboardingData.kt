package com.example.composeplayground.ui.onboardingScreen

import com.example.composeplayground.R


val onBoardingPages = listOf(
    OnboardingPage(
        title = "Welcome to Connectome",
        description = "Navigating your health journey just got a whole lot easier.",
        buttonText = "Let's Get Started",
        image = R.drawable.ic_onboarding_welcome
    ),
    OnboardingPage(
        title = "Your privacy priority",
        description = "We believe you should own your health data and benefit from it.",
        buttonText = "Accept & Continue",
        image = R.drawable.ic_onboarding_privacy
    ),
    OnboardingPage(
        title = "Medical advice disclaimer",
        description = "This app does not replace professional medical advice.",
        buttonText = "Acknowledge",
        image = R.drawable.ic_onboarding_disclaimer
    )
)