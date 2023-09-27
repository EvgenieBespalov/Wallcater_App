package com.example.wallcater_app.binding.search_image.converter

import com.example.data.api.model.ImageApiModel
import com.example.data.database.model.ImageDatabaseModel
import com.example.image_category.domain.entities.ImageEntity

class ImageConverterSearchImageModule {
    fun convertApiModelInEntity(from: ImageApiModel): ImageEntity =
        ImageEntity(
            id = from.id,
            url = from.url,
            width = from.width.toString(),
            height = from.height.toString()
        )

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