package com.example.wallcater_app.binding.search_image.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.api.repository.ApiRepository
import com.example.data.database.repository.DatabaseRepository
import com.example.data.wallpaper_manager.repository.WallpaperManagerRepository
import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.domain.repositories.ImageRepository
import com.example.wallcater_app.binding.search_image.converter.ImageConverter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ImageAdapterRepository(
    private val apiRepository: ApiRepository,
    private val wallpaperManagerRepository: WallpaperManagerRepository,
    private val databaseRepository: DatabaseRepository,
    private val imageConverter: ImageConverter
) : ImageRepository {
    override suspend fun getListImages(categoryId: String): Flow<PagingData<ImageEntity>> =
        apiRepository.getListImages(categoryId).map { pagingData ->
            pagingData.map {
                imageConverter.convertApiModelInEntity(it)
            }
        }

    override suspend fun getImage(id: String): ImageEntity = imageConverter.convertApiModelInEntity(apiRepository.getImage(id))
    override suspend fun setWallpapperOnLockScreen(urlImage: String) = wallpaperManagerRepository.setWallpapperOnLockScreen(urlImage)

    override suspend fun setWallpapperOnSystemScreen(urlImage: String) = wallpaperManagerRepository.setWallpapperOnSystemScreen(urlImage)
    override suspend fun saveImageInDatabase(imageEntity: ImageEntity) =
        withContext(Dispatchers.IO) {
            databaseRepository.saveImage(imageConverter.convertEntityInDatabaseModel(imageEntity))
        }

    override suspend fun getAllImageFromDatabase(): List<ImageEntity> =
    withContext(Dispatchers.IO) {
        databaseRepository.getAllImage().map { imageConverter.convertDatabaseModelInEntity(it) }
    }

    override suspend fun checkSaveImageInDatabase(idImage: String): Boolean =
        withContext(Dispatchers.IO) {
            when(databaseRepository.checkSave(idImage)) {
                null -> false
                else -> true
            }
        }
}