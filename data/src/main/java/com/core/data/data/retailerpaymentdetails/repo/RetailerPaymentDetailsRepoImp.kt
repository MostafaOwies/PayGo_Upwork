package com.core.data.data.retailerpaymentdetails.repo

import com.core.data.data.retailerpaymentdetails.dao.RetailerPaymentDetailsDao
import com.core.domain.entities.RetailerPaymentDetails
import com.core.domain.relations.onetoone.RetailerPaymentDetailsAndRetailer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetailerPaymentDetailsRepoImp @Inject constructor(private val retailerPaymentDetailsDao: RetailerPaymentDetailsDao) :
    RetailerPaymentDetailsRepo {

    override suspend fun insertRetailerPaymentDetails(retailerPaymentDetails: RetailerPaymentDetails) {
        retailerPaymentDetailsDao.insertRetailerPaymentDetails(retailerPaymentDetails)
    }

    override suspend fun deleteRetailerPaymentDetails(retailerPaymentDetails: RetailerPaymentDetails) {
        retailerPaymentDetailsDao.deleteRetailerPaymentDetails(retailerPaymentDetails)
    }

    override fun getAllRetailerPaymentDetails(): Flow<List<RetailerPaymentDetails>> {
        return retailerPaymentDetailsDao.getAllRetailerPaymentDetails()
    }

    override fun getRetailerWithRetailerPaymentDetailsId(retailerPaymentDetailsId: Int): Flow<List<RetailerPaymentDetailsAndRetailer>> {
        return retailerPaymentDetailsDao.getRetailerWithRetailerPaymentDetailsId(
            retailerPaymentDetailsId
        )
    }

}