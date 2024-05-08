package com.daluwi.bottomnavigationbar.ui.navbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

class ComposedIcon(var outlined: ImageVector, var filled: ImageVector) {
    companion object {
        val HOME = ComposedIcon(Icons.Outlined.Home, Icons.Filled.Home)
        val SETTINGS = ComposedIcon(Icons.Outlined.Settings, Icons.Filled.Settings)
        val HISTORY = ComposedIcon(Icons.Outlined.History, Icons.Filled.History)
    }
}
