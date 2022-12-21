package com.core.data.data.discount.dao

import androidx.room.*
import com.core.domain.entities.Discount
import com.core.domain.relations.onetoone.DiscountAndProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface DiscountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiscount(vararg discount: Discount)

    @Delete
    suspend fun deleteDiscount(discount: Discount)

    @Query("SELECT * FROM `Discount`")
    fun getAllDiscounts(): Flow<List<Discount>>

    @Transaction
    @Query("SELECT * FROM Discount WHERE discountId = :discountId")
    fun getDiscountAndProductWithDiscountId(discountId: Int): Flow<List<DiscountAndProduct>>
}