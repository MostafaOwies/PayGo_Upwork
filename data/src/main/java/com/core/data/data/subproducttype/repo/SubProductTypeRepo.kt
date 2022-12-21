package com.core.data.data.subproducttype.repo

import com.core.domain.entities.SubProductType
import com.core.domain.relations.onetomany.SubProductTypeWithSupProduct
import kotlinx.coroutines.flow.Flow

interface SubProductTypeRepo {

    suspend fun insertSubProductType(subProductType: SubProductType)
    suspend fun deleteSubProductType(subProductType: SubProductType)
    fun getAllSubProductTypes(): Flow<List<SubProductType>>
    fun getSubProductTypeWithSupProduct(subProductTypeId: Int): Flow<List<SubProductTypeWithSupProduct>>
}