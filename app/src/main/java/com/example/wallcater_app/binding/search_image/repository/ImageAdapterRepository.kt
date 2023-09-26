package com.example.wallcater_app.binding.search_image.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.api.repository.ApiRepository
import com.example.data.wallpaper_manager.repository.WallpaperRepository
import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.domain.repositories.ImageRepository
import com.example.wallcater_app.binding.search_image.converter.ImageConverter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class ImageAdapterRepository(
    private val apiRepository: ApiRepository,
    private val wallpaperRepository: WallpaperRepository,
    private val imageConverter: ImageConverter
) : ImageRepository {
    override suspend fun getListImages(categoryId: String): Flow<PagingData<ImageEntity>> =
        apiRepository.getListImages(categoryId).map { pagingData ->
            pagingData.map {
                imageConverter.convertModelInEntity(it)
            }
        }

    override suspend fun getImage(id: String): ImageEntity = imageConverter.convertModelInEntity(apiRepository.getImage(id))
    override suspend fun setWallpapperOnLockScreen(urlImage: String) = wallpaperRepository.setWallpapperOnLockScreen(urlImage)

    override suspend fun setWallpapperOnSystemScreen(urlImage: String) = wallpaperRepository.setWallpapperOnSystemScreen(urlImage)
}