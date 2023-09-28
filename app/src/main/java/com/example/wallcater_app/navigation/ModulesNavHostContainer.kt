package com.example.wallcater_app.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.favorite_image.navigation.FavoriteImageModuleNavContainer
import com.example.image_category.screen.SearchImageModuleNavContainer
import com.example.settings.navigation.SettingsModuleNavContainer

@Composable
fun ModulesNavHostContainer(
    navController: NavHostController,
    padding: PaddingValues,
    darkTheme: MutableState<Boolean>
){
    NavHost(
        navController = navController,
        startDestination = ModulesRoutes.searchImageModule.route,
        modifier = Modifier.padding(paddingValues = padding),
        builder = {
            composable(ModulesRoutes.searchImageModule.route) {
                SearchImageModuleNavContainer()
            }

            composable(ModulesRoutes.favoriteImageModule.route) {
                FavoriteImageModuleNavContainer()
            }

            composable(ModulesRoutes.favoriteImageModule.route) {
                SettingsModuleNavContainer(
                    darkTheme
                )
            }
        }
    )
}
