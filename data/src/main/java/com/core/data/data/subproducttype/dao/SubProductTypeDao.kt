package com.core.data.data.subproducttype.dao

import androidx.room.*
import com.core.domain.entities.SubProductType
import com.core.domain.relations.onetomany.SubProductTypeWithSupProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface SubProductTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubProductType(vararg subProductType: SubProductType)

    @Delete
    suspend fun deleteSubProductType(subProductType: SubProductType)

    @Query("SELECT * FROM `SubProductType`")
    fun getAllSubProductTypes(): Flow<List<SubProductType>>

    @Transaction
    @Query("SELECT * FROM SubProductType WHERE subProductTypeId = :subProductTypeId")
    fun getSubProductTypeWithSupProduct(subProductTypeId: Int): Flow<List<SubProductTypeWithSupProduct>>
}