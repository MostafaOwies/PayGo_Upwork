package com.core.data.data.paymentintegration.repo

import com.core.domain.entities.PaymentIntegration
import com.core.domain.relations.onetoone.PaymentIntegrationAndRetailer
import kotlinx.coroutines.flow.Flow

interface PaymentIntegrationRepo {

    suspend fun insertPaymentIntegration(paymentIntegration: PaymentIntegration)
    suspend fun deletePaymentIntegration(paymentIntegration: PaymentIntegration)
    fun getAllPaymentIntegrations(): Flow<List<PaymentIntegration>>
    fun getPaymentIntegrationAndRetailerWithId(paymentIntegrationId: Int): Flow<List<PaymentIntegrationAndRetailer>>
}