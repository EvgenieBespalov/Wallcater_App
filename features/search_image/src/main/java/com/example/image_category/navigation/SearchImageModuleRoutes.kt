package com.example.image_category.navigation


internal sealed class SearchImageModuleRoutes(val route: String) {
    object ListCategoryScreenRoute : SearchImageModuleRoutes("list_category")
    object ListImageScreenRoute : SearchImageModuleRoutes("list_image")
    object ImageScreenRoute : SearchImageModuleRoutes("image_network")
}