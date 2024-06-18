package com.daluwi.bottomnavigationbar

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.daluwi.bottomnavigationbar.ui.navbar.AppNavHost
import com.daluwi.bottomnavigationbar.ui.navbar.BottomNavigationBar
import com.daluwi.bottomnavigationbar.ui.theme.BottomNavigationBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavigationBarTheme {
                // Setting the system navigation bar color
                val window: Window = this.window
                window.navigationBarColor = getNavigationBarColor()

                // Setting up bottom navigation
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController) }
                ) { innerPadding ->
                    AppNavHost(navController, innerPadding)
                }
            }
        }
    }

    @Composable
    fun getNavigationBarColor(): Int {
        return MaterialTheme
            .colorScheme
            .surfaceColorAtElevation(NavigationBarDefaults.Elevation)
            .toArgb()
    }
}
