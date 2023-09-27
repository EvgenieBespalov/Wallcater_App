package com.example.wallcater_app.binding.favorite_image.repository

import com.example.data.database.repository.DatabaseRepository
import com.example.data.wallpaper_manager.repository.WallpaperManagerRepository
import com.example.favorite_image.domain.entites.ImageEntity
import com.example.favorite_image.domain.repositories.ImageRepository
import com.example.wallcater_app.binding.favorite_image.converter.ImageConverterFavoriteImageModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageAdapterFavoriteImageModule(
    private val wallpaperManagerRepository: WallpaperManagerRepository,
    private val databaseRepository: DatabaseRepository,
    private val imageConverter: ImageConverterFavoriteImageModule
) : ImageRepository {
    override suspend fun getListImages(): List<ImageEntity> =
        databaseRepository.getAllImageFromDatabase().map { imageConverter.convertDatabaseModelInEntity(it) }

    override suspend fun getImage(id: String): ImageEntity = imageConverter.convertDatabaseModelInEntity(databaseRepository.getImageByIdFromDatabase(id))

    override suspend fun saveImageInDatabase(imageEntity: ImageEntity) =
        withContext(Dispatchers.IO) {
            databaseRepository.saveImageFromDatabase(imageConverter.convertEntityInDatabaseModel(imageEntity))
        }

    override suspend fun deleteImageFromDatabase(imageEntity: ImageEntity) =
        withContext(Dispatchers.IO) {
            databaseRepository.deleteImageFromDatabase(imageConverter.convertEntityInDatabaseModel(imageEntity))
        }

    override suspend fun checkSaveImageInDatabase(idImage: String): Boolean =
        withContext(Dispatchers.IO) {
            when(databaseRepository.getImageByIdFromDatabase(idImage)) {
                null -> false
                else -> true
            }
        }

    override suspend fun setWallpapperOnLockScreen(urlImage: String) = wallpaperManagerRepository.setWallpapperOnLockScreen(urlImage)

    override suspend fun setWallpapperOnSystemScreen(urlImage: String) = wallpaperManagerRepository.setWallpapperOnSystemScreen(urlImage)
}