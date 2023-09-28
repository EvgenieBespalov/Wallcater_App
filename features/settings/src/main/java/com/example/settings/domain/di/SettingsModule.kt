package com.example.settings.domain.di

import com.example.settings.domain.usecase.ChangeThemeUseCase
import com.example.settings.domain.usecase.GetThemeUseCase
import com.example.settings.presentation.SettingsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideSettingsModule(): Module =
    module {
        viewModel{
            SettingsScreenViewModel(
                getThemeUseCase = get(),
                changeThemeUseCase = get()
            )
        }

        factory {
            ChangeThemeUseCase(repository = get())
        }

        factory {
            GetThemeUseCase(repository = get())
        }
    }