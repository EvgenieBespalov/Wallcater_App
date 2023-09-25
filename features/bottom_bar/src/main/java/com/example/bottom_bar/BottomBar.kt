package com.example.bottom_bar

import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBar(navController: NavHostController, bottomMenuItems: List<BottomMenuItem>){
    NavigationBar(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black),
        tonalElevation = 0.dp,
        //containerColor = Color.Black,
        //contentColor = Color.Red
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomMenuItems.forEach { menuItem ->
            NavigationBarItem(
                selected = (currentRoute == menuItem.route),
                onClick = {
                    navController.navigate(menuItem.route)
                },
                icon = {
                    Icon(
                        imageVector = menuItem.icon,
                        contentDescription = menuItem.label
                    )
                },
                label = {
                    Text(
                        text = menuItem.label
                    )
                },
                enabled = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    //indicatorColor = Color.Transparent
                )
                //alwaysShowLabel = false
            )
        }
    }
}
