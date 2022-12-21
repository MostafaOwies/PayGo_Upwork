package com.core.data.data.retailerpaymentdetails.dao

import androidx.room.*
import com.core.domain.entities.RetailerPaymentDetails
import com.core.domain.relations.onetoone.RetailerPaymentDetailsAndRetailer
import kotlinx.coroutines.flow.Flow

@Dao
interface RetailerPaymentDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRetailerPaymentDetails(vararg retailerPaymentDetails: RetailerPaymentDetails)

    @Delete
    suspend fun deleteRetailerPaymentDetails(retailerPaymentDetails: RetailerPaymentDetails)

    @Query("SELECT * FROM RetailerPaymentDetails")
    fun getAllRetailerPaymentDetails(): Flow<List<RetailerPaymentDetails>>

    @Transaction
    @Query("SELECT * FROM RetailerPaymentDetails WHERE retailerPaymentDetailsId = :retailerPaymentDetailsId")
    fun getRetailerWithRetailerPaymentDetailsId(retailerPaymentDetailsId: Int): Flow<List<RetailerPaymentDetailsAndRetailer>>
}