package com.example.wallcater_app.binding.search_image.di

import com.example.data.api.repository.ApiRepository
import com.example.image_category.domain.repositories.CategoryRepository
import com.example.wallcater_app.binding.search_image.converter.CategoryConverter
import com.example.wallcater_app.binding.search_image.repository.CategoryAdapterRepository
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideCategoryAdapterRepository(
    apiRepository: ApiRepository,
    categoryConverter: CategoryConverter
): CategoryRepository = CategoryAdapterRepository(apiRepository, categoryConverter)

fun provideSearchImageBindingModule(): Module =
    module {
        factory { CategoryConverter() }
        single {
            provideCategoryAdapterRepository(
                apiRepository = get(),
                categoryConverter = get()
            )
        }
    }