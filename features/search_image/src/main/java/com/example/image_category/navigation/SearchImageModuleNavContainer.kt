package com.example.image_category.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.image_category.navigation.SearchImageModuleRoutes

@Composable
fun SearchImageModuleNavContainer(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SearchImageModuleRoutes.ListCategoryScreenRoute.route,
        //modifier = Modifier.padding(paddingValues = padding),
        builder = {
            composable(SearchImageModuleRoutes.ListCategoryScreenRoute.route) {
                ListCategoryScreen(navController = navController)
            }

            composable(SearchImageModuleRoutes.ListImageScreenRoute.route + "/{categoryId}") {
                it.arguments?.getString("categoryId")?.let { it1 ->
                    ListImageScreen(
                        navController = navController,
                        categoryId = it1
                    )
                }
            }
        }
    )
}