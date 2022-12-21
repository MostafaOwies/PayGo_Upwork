package com.core.data.data.category.dao

import androidx.room.*
import com.core.domain.entities.category.Category
import com.core.domain.relations.onetomany.CategoryWithProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(vararg category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Query("SELECT * FROM Category")
    fun getAllCategories(): Flow<List<Category>>

    @Transaction
    @Query("SELECT * FROM Category WHERE categoryId = :categoryId")
    fun getCategoryWithProduct(categoryId: Int): Flow<List<CategoryWithProduct>>

    @Query("SELECT * FROM Category WHERE categoryId = :categoryId")
    fun getCategoryList(categoryId: Int) :Flow<List<Category>>
}