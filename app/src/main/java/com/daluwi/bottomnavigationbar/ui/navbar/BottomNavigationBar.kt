package com.daluwi.bottomnavigationbar.ui.navbar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    var selectedItem by rememberSaveable { mutableIntStateOf(1) }
    val items = listOf(
        BottomNavigationItem.HISTORY,
        BottomNavigationItem.HOME,
        BottomNavigationItem.SETTINGS
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.description } == true

            NavigationBarItem(
                icon = {
                    Icon(
                        item.getImageVector(selected), contentDescription = item.description)
                       },
                label = { Text(item.description) },
                selected = selected,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.description) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}