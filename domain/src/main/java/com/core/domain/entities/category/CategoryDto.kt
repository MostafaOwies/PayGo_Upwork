package com.core.domain.entities.category

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @PrimaryKey
    @field:SerializedName("categoryId")
    var categoryId: String = "",
    @field:SerializedName("name")
    var name: String? = "",
){
    fun toCategory () :Category{
        return Category(
            categoryId = categoryId.toInt(),
            name = name
        )
    }
}
