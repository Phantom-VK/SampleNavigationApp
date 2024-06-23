package com.example.navigationsampleapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ThirdScreen(navigateToFirstScreen:()->Unit){
    Box (modifier = Modifier.padding(8.dp).fillMaxSize(),
        contentAlignment = Alignment.Center){
        Button(onClick = { navigateToFirstScreen() }) {
            Text(text = "This is third screen!\nClick to go to First Screen")
        }
    }

}