package com.example.navigationsampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsampleapp.ui.theme.NavigationSampleAppTheme

/**
 * MainActivity sets up the content view and applies the app theme.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

/**
 * MyApp sets up the navigation for the app.
 */
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "firstscreen") {
        composable("firstscreen") {
            FirstScreen { name, age ->
                navController.navigate("secondscreen/$name/$age")
            }
        }
        composable("secondscreen/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "No name"
            val age = backStackEntry.arguments?.getString("age")?.toIntOrNull() ?: 0
            SecondScreen(name, age) {
                navController.navigate("thirdscreen")
            }
        }
        composable("thirdscreen") {
            ThirdScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}
