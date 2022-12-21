package com.core.data.data.category.repo

import com.core.domain.entities.category.Category
import com.core.domain.relations.onetomany.CategoryWithProduct
import kotlinx.coroutines.flow.Flow

interface CategoryRepo {

    suspend fun insertCategory(category: Category)
    suspend fun deleteCategory(category: Category)
    fun getAllCategories(): Flow<List<Category>>
    fun getCategoryWithProduct(categoryId: Int): Flow<List<CategoryWithProduct>>
    fun getCategoryList(categoryId: Int) :Flow<List<Category>>

}
