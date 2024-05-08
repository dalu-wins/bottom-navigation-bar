package com.daluwi.bottomnavigationbar.ui.navbar

import androidx.compose.ui.graphics.vector.ImageVector


class BottomNavigationItem(var composedIcon: ComposedIcon, var description: String) {
    companion object {
        val HOME = BottomNavigationItem(ComposedIcon.HOME, "Home")
        val SETTINGS = BottomNavigationItem(ComposedIcon.SETTINGS, "Settings")
        val HISTORY = BottomNavigationItem(ComposedIcon.HISTORY, "History")
    }

    fun getImageVector(selected: Boolean): ImageVector {
        val filled = this.composedIcon.filled
        val outlined = this.composedIcon.outlined
        return when (selected) {
            true -> filled
            false -> outlined
        }
    }
}