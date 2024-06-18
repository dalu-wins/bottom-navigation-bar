package com.daluwi.bottomnavigationbar

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daluwi.bottomnavigationbar.ui.navbar.BottomNavigationBar
import com.daluwi.bottomnavigationbar.ui.navbar.BottomNavigationItem
import com.daluwi.bottomnavigationbar.ui.screen.HistoryScreen
import com.daluwi.bottomnavigationbar.ui.screen.HomeScreen
import com.daluwi.bottomnavigationbar.ui.screen.SettingsScreen
import com.daluwi.bottomnavigationbar.ui.theme.BottomNavigationBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavigationBarTheme {
                val window: Window = this.window
                window.navigationBarColor = getNavigationBarColor()
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController) }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavigationItem.HOME.description,
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    ) {
                        composable(
                            route = BottomNavigationItem.HISTORY.description,
                        ) {
                            HistoryScreen(navController)
                        }
                        composable(
                            route = BottomNavigationItem.HOME.description
                        ) {
                            HomeScreen(navController)
                        }
                        composable(
                            route = BottomNavigationItem.SETTINGS.description,
                        ) {
                            SettingsScreen(navController)
                        }
                    }
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
