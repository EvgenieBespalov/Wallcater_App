package com.example.wallcater_app.navigation

sealed class ModulesRoutes(val route: String) {
    object searchImageModule : ModulesRoutes("searchImageModule")
    object listFavorite : ModulesRoutes("list_favorite")
    object listFile : ModulesRoutes("list_file")
    object settingsModule : ModulesRoutes("settingsModule")
}