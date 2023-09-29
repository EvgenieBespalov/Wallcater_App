package com.example.wallcater_app.ui.domain.repository

interface ThemeRepository {
    suspend fun getTheme(): Boolean
}