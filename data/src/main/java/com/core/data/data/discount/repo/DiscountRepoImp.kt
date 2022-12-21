package com.core.data.data.discount.repo

import com.core.data.data.discount.dao.DiscountDao
import com.core.domain.entities.Discount
import com.core.domain.relations.onetoone.DiscountAndProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DiscountRepoImp @Inject constructor(private val discountDao: DiscountDao) : DiscountRepo {

    override suspend fun insertDiscount(discount: Discount) {
        discountDao.insertDiscount(discount)
    }

    override suspend fun deleteDiscount(discount: Discount) {
        discountDao.deleteDiscount(discount)
    }

    override fun getAllDiscounts(): Flow<List<Discount>> {
        return discountDao.getAllDiscounts()
    }

    override fun getDiscountAndProductWithDiscountId(discountId: Int): Flow<List<DiscountAndProduct>> {
        return discountDao.getDiscountAndProductWithDiscountId(discountId)
    }
}