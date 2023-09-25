package com.example.wallcater_app.binding.search_image.di

import com.example.data.api.repository.ApiRepository
import com.example.image_category.domain.repositories.CategoryRepository
import com.example.image_category.domain.repositories.ImageRepository
import com.example.wallcater_app.binding.search_image.converter.CategoryConverter
import com.example.wallcater_app.binding.search_image.converter.ImageConverter
import com.example.wallcater_app.binding.search_image.repository.CategoryAdapterRepository
import com.example.wallcater_app.binding.search_image.repository.ImageAdapterRepository
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideCategoryAdapterRepository(
    apiRepository: ApiRepository,
    converter: CategoryConverter
): CategoryRepository = CategoryAdapterRepository(apiRepository, converter)

private fun provideImageAdapterRepository(
    apiRepository: ApiRepository,
    converter: ImageConverter
): ImageRepository = ImageAdapterRepository(apiRepository, converter)

fun provideSearchImageBindingModule(): Module =
    module {
        factory { CategoryConverter() }
        factory { ImageConverter() }

        single {
            provideCategoryAdapterRepository(
                apiRepository = get(),
                converter = get()
            )
        }
        single {
            provideImageAdapterRepository(
                apiRepository = get(),
                converter = get()
            )
        }
    }