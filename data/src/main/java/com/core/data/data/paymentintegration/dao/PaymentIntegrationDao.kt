package com.core.data.data.paymentintegration.dao

import androidx.room.*
import com.core.domain.entities.PaymentIntegration
import com.core.domain.relations.onetoone.PaymentIntegrationAndRetailer
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentIntegrationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaymentIntegration(vararg paymentIntegration: PaymentIntegration)

    @Delete
    suspend fun deletePaymentIntegration(paymentIntegration: PaymentIntegration)

    @Query("SELECT * FROM PaymentIntegration")
    fun getAllPaymentIntegrations(): Flow<List<PaymentIntegration>>

    @Transaction
    @Query("SELECT * FROM PaymentIntegration WHERE paymentIntegrationId = :paymentIntegrationId")
    fun getPaymentIntegrationAndRetailerWithId(paymentIntegrationId: Int): Flow<List<PaymentIntegrationAndRetailer>>
}