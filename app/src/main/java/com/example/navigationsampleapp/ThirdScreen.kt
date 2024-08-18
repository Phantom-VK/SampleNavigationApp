package com.example.navigationsampleapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * ThirdScreen composable function that displays a button to navigate back to the FirstScreen.
 *
 * @param navigateToFirstScreen Lambda function to handle navigation to the FirstScreen.
 */
@Composable
fun ThirdScreen(navigateToFirstScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Button to navigate back to the first screen
        Button(onClick = { navigateToFirstScreen() }) {
            Text(text = "This is third screen!\nClick to go to First Screen")
        }
    }
}
