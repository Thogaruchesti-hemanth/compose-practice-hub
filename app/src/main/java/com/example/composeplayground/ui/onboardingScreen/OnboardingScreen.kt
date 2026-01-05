package com.example.composeplayground.ui.onboardingScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {
    val pagerState = rememberPagerState { onBoardingPages.size }

    HorizontalPager(state = pagerState) { index ->
        val page = onBoardingPages[index]

        OnboardingPageContent(
            page = page,
            currentPage = pagerState.currentPage,
            totalPages = onBoardingPages.size,
            onButtonClick = {
                if (index == onBoardingPages.lastIndex) {
                    onFinish()
                }
            }
        )
    }
}