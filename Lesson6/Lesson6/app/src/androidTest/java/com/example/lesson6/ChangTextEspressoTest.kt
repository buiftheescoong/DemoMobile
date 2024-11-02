package com.example.lesson6

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangTextEspressoTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun changeText_sameActivity() {
        composeTestRule.setContent {
            MyApp()
        }
        composeTestRule.onNodeWithText("Enter text")
            .performTextInput("Hello Compose")
        composeTestRule.onNodeWithText("Change Text")
            .performClick()
        composeTestRule.onNodeWithTag("displayedText")
            .assertTextEquals("Hello Compose")
    }
}

