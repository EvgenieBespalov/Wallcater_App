package com.example.settings.domain.usecase

import com.example.settings.domain.repositories.SettingsRepository

internal class ChangeThemeUseCase(
    private val repository: SettingsRepository
) {
    suspend operator fun invoke(theme: Boolean) = repository.changeTheme(theme)
}