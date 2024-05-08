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

@Composable
fun BottomNavigationBar() {

    var selectedItem by rememberSaveable { mutableIntStateOf(1) }
    val items = listOf(
        BottomNavigationItem.HISTORY,
        BottomNavigationItem.HOME,
        BottomNavigationItem.SETTINGS
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            val selected = selectedItem == index
            NavigationBarItem(
                icon = {
                    Icon(
                        item.getImageVector(selected), contentDescription = item.description)
                       },
                label = { Text(item.description) },
                selected = selected,
                onClick = {
                    selectedItem = index
                }
            )
        }
    }
}