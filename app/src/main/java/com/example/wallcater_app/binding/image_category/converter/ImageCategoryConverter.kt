package com.example.wallcater_app.binding.image_category.converter

import com.example.data.api.model.CategoryApiModel
import com.example.data.api.model.ImageApiModel
import com.example.image_category.domain.entities.CategoryEntity
import com.example.image_category.domain.entities.ImageEntity

class ImageCategoryConverter {
    fun convertImageApiModelToEntity(from: ImageApiModel): ImageEntity =
        ImageEntity(
            id = from.id.toString(),
            url = from.url,
            width = from.width.toString(),
            height = from.height.toString()
        )

    fun convertCategoryApiModelToEntity(from: CategoryApiModel): CategoryEntity =
        CategoryEntity(
            id = from.id.toString(),
            name = from.name
        )
}