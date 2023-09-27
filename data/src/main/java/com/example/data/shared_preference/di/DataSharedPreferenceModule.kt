package com.example.data.shared_preference.di

import com.example.data.shared_preference.data_source.SharedPreferencesManager
import com.example.data.shared_preference.repository.SharedPreferenceRepository
import com.example.data.shared_preference.repository.SharedPreferenceRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideSharedPreferenceRepository(
    sharedPreferencesManager: SharedPreferencesManager
): SharedPreferenceRepository = SharedPreferenceRepositoryImpl(sharedPreferencesManager)

fun provideSharedPreferenceModule(): Module =
    module {
        single {
            SharedPreferencesManager(androidApplication())
        }

        single {
            provideSharedPreferenceRepository(sharedPreferencesManager = get())
        }
    }