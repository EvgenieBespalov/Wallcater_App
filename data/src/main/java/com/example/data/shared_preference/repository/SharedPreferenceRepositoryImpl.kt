package com.example.data.shared_preference.repository

import com.example.data.shared_preference.data_source.SharedPreferencesManager

internal class SharedPreferenceRepositoryImpl(
    private val sharedPreferencesManager: SharedPreferencesManager
) : SharedPreferenceRepository{
    override suspend fun getTheme(): Boolean = sharedPreferencesManager.darkTheme

    override suspend fun changeTheme(theme: Boolean) = sharedPreferencesManager.changeTheme(theme)
}