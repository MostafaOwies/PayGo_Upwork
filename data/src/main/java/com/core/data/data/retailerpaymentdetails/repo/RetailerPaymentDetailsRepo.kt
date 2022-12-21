package com.core.data.data.retailerpaymentdetails.repo

import com.core.domain.entities.RetailerPaymentDetails
import com.core.domain.relations.onetoone.RetailerPaymentDetailsAndRetailer
import kotlinx.coroutines.flow.Flow

interface RetailerPaymentDetailsRepo {

    suspend fun insertRetailerPaymentDetails(retailerPaymentDetails: RetailerPaymentDetails)
    suspend fun deleteRetailerPaymentDetails(retailerPaymentDetails: RetailerPaymentDetails)
    fun getAllRetailerPaymentDetails(): Flow<List<RetailerPaymentDetails>>
    fun getRetailerWithRetailerPaymentDetailsId(retailerPaymentDetailsId: Int): Flow<List<RetailerPaymentDetailsAndRetailer>>
}