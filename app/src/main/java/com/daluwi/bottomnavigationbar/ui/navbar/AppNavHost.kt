package com.daluwi.bottomnavigationbar.ui.navbar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.daluwi.bottomnavigationbar.ui.screen.HistoryScreen
import com.daluwi.bottomnavigationbar.ui.screen.HomeScreen
import com.daluwi.bottomnavigationbar.ui.screen.SettingsScreen

@Composable
fun AppNavHost(navController: NavHostController, innerPadding: PaddingValues) {
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