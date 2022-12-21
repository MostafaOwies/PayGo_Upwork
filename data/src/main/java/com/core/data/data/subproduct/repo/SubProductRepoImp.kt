package com.core.data.data.subproduct.repo

import com.core.data.data.subproduct.dao.SubProductDao
import com.core.domain.entities.SubProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SubProductRepoImp @Inject constructor(private val subProductDao: SubProductDao) :
    SubProductRepo {
    override suspend fun insertSubProduct(subProduct: SubProduct) {
        return subProductDao.insertSubProduct(subProduct)
    }

    override suspend fun deleteSubProduct(subProduct: SubProduct) {
        subProductDao.deleteSubProduct(subProduct)
    }

    override fun getAllSubProducts(): Flow<List<SubProduct>> {
        return subProductDao.getAllSubProducts()
    }
}