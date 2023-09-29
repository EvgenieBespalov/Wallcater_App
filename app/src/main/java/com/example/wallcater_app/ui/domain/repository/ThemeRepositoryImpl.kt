package com.example.wallcater_app.ui.domain.repository

import com.example.data.shared_preference.repository.SharedPreferenceRepository

class ThemeRepositoryImpl(
    private val sharedPreferenceRepository: SharedPreferenceRepository
) : ThemeRepository {
    override suspend fun getTheme(): Boolean = sharedPreferenceRepository.getTheme()
}