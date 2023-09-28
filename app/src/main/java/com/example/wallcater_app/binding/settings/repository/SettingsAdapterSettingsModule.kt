package com.example.wallcater_app.binding.settings.repository

import com.example.data.shared_preference.repository.SharedPreferenceRepository
import com.example.settings.domain.repositories.SettingsRepository

class SettingsAdapterSettingsModule(
    private val sharedPreferenceRepository: SharedPreferenceRepository
) : SettingsRepository{
    override suspend fun getTheme(): Boolean = sharedPreferenceRepository.getTheme()

    override suspend fun changeTheme(theme: Boolean) = sharedPreferenceRepository.changeTheme(theme)
}