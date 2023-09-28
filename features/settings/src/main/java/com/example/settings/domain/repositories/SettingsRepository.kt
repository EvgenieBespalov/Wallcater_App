package com.example.settings.domain.repositories

interface SettingsRepository {
    suspend fun getTheme(): Boolean

    suspend fun changeTheme(theme: Boolean)
}