package com.example.navigationsampleapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * SecondScreen composable function that displays the user's name and age.
 * On pressing the button, it navigates to the ThirdScreen.
 *
 * @param name User's name.
 * @param age User's age.
 * @param navigateToFirstScreen Lambda function to handle navigation to the FirstScreen.
 */
@Composable
fun SecondScreen(name: String, age: Int, navigateToFirstScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Second Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Welcome $name!", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Your age is: $age", fontSize = 24.sp)

        // Button to navigate to the third screen
        Button(onClick = { navigateToFirstScreen() }) {
            Text(text = "Go to Third screen!")
        }
    }
}
