package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.compose.ui.LoginScreen
import com.example.compose.ui.splash.SplashScreen
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTheme {

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

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen
    ) {

        composable<Screen.SplashScreen> {
            SplashScreen(navController)
        }

        composable<Screen.LoginScreen> {
            LoginScreen(navController)
        }

        composable<Screen.ScreenA> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting("Mohamed") {
                    navController.navigate(Screen.ScreenB("from A"))
                }
            }
        }

        composable<Screen.ScreenB> {
            val args = it.toRoute<Screen.ScreenB>()
            val name = args.name

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting(name = name) {
                    navController.navigateUp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onCLick: () -> Unit) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.clickable { onCLick() },
    )
}