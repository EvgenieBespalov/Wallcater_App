package com.example.data.shared_preference.repository

interface SharedPreferenceRepository {
    suspend fun getTheme(): Boolean

    suspend fun changeTheme(theme: Boolean)
}