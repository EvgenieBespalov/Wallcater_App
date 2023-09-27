package com.example.favorite_image.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.favorite_image.screen.ImageScreen
import com.example.favorite_image.screen.ListImageScreen

@Composable
fun FavoriteImageModuleNavContainer(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FavoriteImageModuleRoutes.ListImageScreenRoute.route,
        //modifier = Modifier.padding(paddingValues = padding),
        builder = {
            composable(FavoriteImageModuleRoutes.ListImageScreenRoute.route) {
                ListImageScreen(
                    navController = navController
                )
            }

            composable(FavoriteImageModuleRoutes.ImageScreenRoute.route + "/{imageId}") {
                it.arguments?.getString("imageId")?.let { it1 ->
                    ImageScreen(
                        imageId = it1
                    )
                }
            }
        }
    )
}