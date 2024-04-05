package com.example.cryptotrackerapp.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    var route: String,
    var unselectedIcon: ImageVector,
    var selectedIcon: ImageVector,
    var title: String
) {
    data object Home : BottomNavItem(
        route = "home",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        title = "Home"
    )
    data object Favourites : BottomNavItem(
        route = "favourites",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        title = "Favourites"
    )

    data object Profile : BottomNavItem(
        route = "profile",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        title = "Profile"
    )
}