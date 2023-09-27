package com.example.favorite_image.navigation


internal sealed class FavoriteImageModuleRoutes(val route: String) {
    object ListImageScreenRoute : FavoriteImageModuleRoutes("list_favorite_image")
    object ImageScreenRoute : FavoriteImageModuleRoutes("image_favorite")
}