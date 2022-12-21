package com.core.data.data.subproduct.dao

import androidx.room.*
import com.core.domain.entities.SubProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface SubProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubProduct(subProduct: SubProduct)

    @Delete
    suspend fun deleteSubProduct(subProduct: SubProduct)

    @Query("SELECT * FROM SubProduct")
    fun getAllSubProducts(): Flow<List<SubProduct>>
}