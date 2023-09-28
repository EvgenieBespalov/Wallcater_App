package com.example.settings.navigation

internal sealed class SettingsModuleRoutes(val route: String) {
    object SettingsScreenRoute : SettingsModuleRoutes("settings_main")
}
