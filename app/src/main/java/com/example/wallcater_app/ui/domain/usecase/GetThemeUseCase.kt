package com.example.wallcater_app.ui.domain.usecase

import com.example.wallcater_app.ui.domain.repository.ThemeRepository

class GetThemeUseCase(
    private val repository: ThemeRepository
) {
    suspend operator fun invoke(): Boolean = repository.getTheme()
}