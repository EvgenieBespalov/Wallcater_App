package com.example.settings.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.settings.screen.SettingsScreen

@Composable
fun SettingsModuleNavContainer(
    darkTheme: MutableState<Boolean>
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SettingsModuleRoutes.SettingsScreenRoute.route,
        //modifier = Modifier.padding(paddingValues = padding),
        builder = {
            composable(SettingsModuleRoutes.SettingsScreenRoute.route) {
                SettingsScreen(
                    navController = navController,
                    darkTheme = darkTheme
                )
            }
        }
    )
}