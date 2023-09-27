package com.example.data.shared_preference.data_source

import android.content.Context
import android.content.SharedPreferences

internal class SharedPreferencesManager (context: Context) {
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences("user_shared_preferences",
            Context.MODE_PRIVATE
        )
    }

    val darkTheme: Boolean
        get() = sharedPreferences.getBoolean("DARK_THEME", true)

    fun changeTheme(theme: Boolean) {
        sharedPreferences.edit().putBoolean("DARK_THEME", !theme).apply()
    }
}