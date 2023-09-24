package com.example.wallcater_app.binding.search_image.converter

import com.example.data.api.model.CategoryApiModel
import com.example.image_category.domain.entities.CategoryEntity

class CategoryConverter {
    fun convertApiModelToEntity(from: CategoryApiModel): CategoryEntity =
        CategoryEntity(
            id = from.id.toString(),
            name = from.name
        )
}