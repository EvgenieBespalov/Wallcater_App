package com.example.wallcater_app.binding.settings.di

import com.example.data.shared_preference.repository.SharedPreferenceRepository
import com.example.settings.domain.repositories.SettingsRepository
import com.example.wallcater_app.binding.settings.repository.SettingsAdapterSettingsModule
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideSettingsAdapterRepository(
    sharedPreferenceRepository: SharedPreferenceRepository
) : SettingsRepository = SettingsAdapterSettingsModule(sharedPreferenceRepository)

fun provideSettingsBindingModule(): Module =
    module {
        single {
            provideSettingsAdapterRepository(
                sharedPreferenceRepository = get()
            )
        }
    }