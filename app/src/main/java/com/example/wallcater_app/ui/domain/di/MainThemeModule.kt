package com.example.wallcater_app.ui.domain.di

import com.example.data.shared_preference.repository.SharedPreferenceRepository
import com.example.wallcater_app.ui.domain.repository.ThemeRepository
import com.example.wallcater_app.ui.domain.repository.ThemeRepositoryImpl
import com.example.wallcater_app.ui.domain.usecase.GetThemeUseCase
import com.example.wallcater_app.ui.presentation.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideMainThemeRepository(
    sharedPreferenceRepository: SharedPreferenceRepository
): ThemeRepository = ThemeRepositoryImpl(sharedPreferenceRepository)

fun provideMainThemeModule(): Module =
    module {
        single {
            provideMainThemeRepository(
                sharedPreferenceRepository = get()
            )
        }

        viewModel{
            MainScreenViewModel(
                getThemeUseCase = get(),
            )
        }

        factory {
            GetThemeUseCase(repository = get())
        }
    }