package com.example.image_category.domain.di

import com.example.image_category.domain.usecase.GetListCategoriesUseCase
import com.example.image_category.presentation.ScreenCategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideImageCategoryModule(): Module =
    module {
        viewModel {
            ScreenCategoryViewModel(
                getListCategoriesUseCase = get()
            )
        }
        factory { GetListCategoriesUseCase(repository = get()) }
    }