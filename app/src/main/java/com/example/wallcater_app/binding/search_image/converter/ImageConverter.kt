package com.example.wallcater_app.binding.search_image.converter

import com.example.data.api.model.ImageApiModel
import com.example.image_category.domain.entities.ImageEntity

class ImageConverter {
    fun convertModelInEntity(from: ImageApiModel): ImageEntity =
        ImageEntity(
            id = from.id,
            url = from.url,
            width = from.width.toString(),
            height = from.height.toString()
        )
}