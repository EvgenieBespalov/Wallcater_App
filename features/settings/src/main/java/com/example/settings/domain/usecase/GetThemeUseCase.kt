package com.example.settings.domain.usecase

import com.example.settings.domain.repositories.SettingsRepository

internal class GetThemeUseCase(
    private val repository: SettingsRepository
) {
    suspend operator fun invoke(): Boolean = repository.getTheme()
}