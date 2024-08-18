package com.example.navigationsampleapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * FirstScreen composable function that allows users to input their name and age.
 * On pressing the button, it navigates to the SecondScreen with the input data.
 *
 * @param navigateToSecondScreen Lambda function to handle navigation to the SecondScreen.
 */
@Composable
fun FirstScreen(navigateToSecondScreen: (String, Int) -> Unit) {
    // State to hold user input
    val name = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "First Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        // Input field for name
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text(text = "Enter name") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Input field for age
        OutlinedTextField(
            value = age.value,
            onValueChange = { age.value = it },
            label = { Text(text = "Enter age") }
        )

        // Button to navigate to the next screen
        Button(onClick = {
            // Safely convert age to Int and navigate
            val ageInt = age.value.toIntOrNull() ?: 0
            navigateToSecondScreen(name.value, ageInt)
        }) {
            Text(text = "Go to next screen!")
        }
    }
}
