package com.daluwi.bottomnavigationbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
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
//                            enterTransition = { EnterTransition.None },
//                            exitTransition = { ExitTransition.None }
                        ) {
                            HistoryScreen(navController)
                        }
                        composable(
                            route = BottomNavigationItem.HOME.description,
//                            enterTransition = { EnterTransition.None },
//                            exitTransition = { ExitTransition.None }
                        ) {
                            HomeScreen(navController)
                        }
                        composable(
                            route = BottomNavigationItem.SETTINGS.description,
//                            enterTransition = { EnterTransition.None },
//                            exitTransition = { ExitTransition.None }
                        ) {
                            SettingsScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
