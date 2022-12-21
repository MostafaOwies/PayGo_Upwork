package com.core.data.data.subproducttype.repo

import com.core.data.data.subproducttype.dao.SubProductTypeDao
import com.core.domain.entities.SubProductType
import com.core.domain.relations.onetomany.SubProductTypeWithSupProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SubProductTypeRepoImp @Inject constructor(private val subProductTypeDao: SubProductTypeDao) :
    SubProductTypeRepo {
    override suspend fun insertSubProductType(subProductType: SubProductType) {
        subProductTypeDao.insertSubProductType(subProductType)
    }

    override suspend fun deleteSubProductType(subProductType: SubProductType) {
        subProductTypeDao.deleteSubProductType(subProductType)
    }

    override fun getAllSubProductTypes(): Flow<List<SubProductType>> {
        return subProductTypeDao.getAllSubProductTypes()
    }

    override fun getSubProductTypeWithSupProduct(subProductTypeId: Int): Flow<List<SubProductTypeWithSupProduct>> {
        return subProductTypeDao.getSubProductTypeWithSupProduct(subProductTypeId)
    }
}