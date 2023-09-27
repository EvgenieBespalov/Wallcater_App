package com.example.favorite_image.domain.di

import com.example.favorite_image.domain.usecase.*
import com.example.favorite_image.domain.usecase.GetImageByIdUseCase
import com.example.favorite_image.domain.usecase.GetListImagesUseCase
import com.example.favorite_image.domain.usecase.SetWallpapperOnLockScreenUseCase
import com.example.favorite_image.domain.usecase.SetWallpapperOnSystemScreenUseCase
import com.example.favorite_image.presentation.ImageScreenViewModel
import com.example.favorite_image.presentation.ListImageScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideFavoriteImageModule(): Module =
    module {
        viewModel {
            ListImageScreenViewModel(
                getListImagesUseCase = get(),
            )
        }
        factory { GetListImagesUseCase(repository = get()) }

        viewModel {
            ImageScreenViewModel(
                getImageByIdUseCase = get(),
                setWallpapperOnLockScreenUseCase = get(),
                setWallpapperOnSystemScreenUseCase = get(),
                checkSaveImageInDatabaseUseCase = get(),
                saveImageInDatabaseUseCase = get(),
                deleteImageFromDatabaseUseCase = get()
            )
        }
        factory { GetImageByIdUseCase(repository = get()) }
        factory { SetWallpapperOnLockScreenUseCase(repository = get()) }
        factory { SetWallpapperOnSystemScreenUseCase(repository = get()) }
        factory { CheckSaveImageInDatabaseUseCase(repository = get()) }
        factory { SaveImageInDatabaseUseCase(repository = get()) }
        factory { DeleteImageFromDatabaseUseCase(repository = get()) }
    }

