package com.example.wallcater_app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import com.example.bottom_bar.BottomMenuItem


object ListOfBottomMenuItems {
    val BottomMenuItems = listOf(
        BottomMenuItem(
            label = "Search",
            icon = Icons.Outlined.Search,
            route = ModulesRoutes.searchImageModule.route
        ),
        BottomMenuItem(
            label = "Favorites",
            icon = Icons.Outlined.Star,
            route = ModulesRoutes.settingsModule.route
        )
    )
}