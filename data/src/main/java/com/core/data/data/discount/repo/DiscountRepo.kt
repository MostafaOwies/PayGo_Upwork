package com.core.data.data.discount.repo

import com.core.domain.entities.Discount
import com.core.domain.relations.onetoone.DiscountAndProduct
import kotlinx.coroutines.flow.Flow

interface DiscountRepo {

    suspend fun insertDiscount(discount: Discount)
    suspend fun deleteDiscount(discount: Discount)
    fun getAllDiscounts(): Flow<List<Discount>>
    fun getDiscountAndProductWithDiscountId(discountId: Int): Flow<List<DiscountAndProduct>>

}