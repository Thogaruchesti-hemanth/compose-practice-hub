package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.composeplayground.TipTimeLayout
import com.example.composeplayground.ui.theme.ComposeTestTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get: Rule
    val composeTextRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTextRule.setContent {
            ComposeTestTheme{
                TipTimeLayout()
            }
        }
        composeTextRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTextRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTextRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with the text was found."
        )
    }
}