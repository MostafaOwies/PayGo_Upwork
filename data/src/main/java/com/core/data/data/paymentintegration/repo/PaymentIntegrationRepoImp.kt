package com.core.data.data.paymentintegration.repo

import com.core.data.data.paymentintegration.dao.PaymentIntegrationDao
import com.core.domain.entities.PaymentIntegration
import com.core.domain.relations.onetoone.PaymentIntegrationAndRetailer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PaymentIntegrationRepoImp @Inject constructor(private val paymentIntegrationDao: PaymentIntegrationDao) :
    PaymentIntegrationRepo {

    override suspend fun insertPaymentIntegration(paymentIntegration: PaymentIntegration) {
        paymentIntegrationDao.insertPaymentIntegration(paymentIntegration)
    }

    override suspend fun deletePaymentIntegration(paymentIntegration: PaymentIntegration) {
        paymentIntegrationDao.deletePaymentIntegration(paymentIntegration)
    }

    override fun getAllPaymentIntegrations(): Flow<List<PaymentIntegration>> {
        return paymentIntegrationDao.getAllPaymentIntegrations()
    }

    override fun getPaymentIntegrationAndRetailerWithId(paymentIntegrationId: Int): Flow<List<PaymentIntegrationAndRetailer>> {
        return paymentIntegrationDao.getPaymentIntegrationAndRetailerWithId(paymentIntegrationId)
    }
}