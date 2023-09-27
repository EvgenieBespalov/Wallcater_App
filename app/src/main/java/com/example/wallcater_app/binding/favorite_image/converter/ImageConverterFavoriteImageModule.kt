package com.example.wallcater_app.binding.favorite_image.converter

import com.example.data.api.model.ImageApiModel
import com.example.data.database.model.ImageDatabaseModel
import com.example.favorite_image.domain.entites.ImageEntity

class ImageConverterFavoriteImageModule {
    fun convertDatabaseModelInEntity(from: ImageDatabaseModel): ImageEntity =
        ImageEntity(
            id = from.id,
            url = from.url,
            width = from.width,
            height = from.height
        )

    fun convertEntityInDatabaseModel(from: ImageEntity): ImageDatabaseModel =
        ImageDatabaseModel(
            id = from.id,
            url = from.url,
            width = from.width,
            height = from.height
        )
}