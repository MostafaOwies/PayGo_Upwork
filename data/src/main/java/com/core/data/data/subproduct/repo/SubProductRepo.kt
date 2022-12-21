package com.core.data.data.subproduct.repo


import com.core.domain.entities.SubProduct
import kotlinx.coroutines.flow.Flow

interface SubProductRepo {

    suspend fun insertSubProduct(subProduct: SubProduct)
    suspend fun deleteSubProduct(subProduct: SubProduct)
    fun getAllSubProducts(): Flow<List<SubProduct>>
}