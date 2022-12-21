package com.core.data.data.retailer.repo

import com.core.data.data.retailer.dao.RetailerDao
import com.core.domain.entities.Retailer
import com.core.domain.relations.onetomany.RetailerWithBookings
import com.core.domain.relations.onetomany.RetailerWithOrders
import com.core.domain.relations.onetoone.RetailerAndUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetailerRepoImp @Inject constructor(private val retailerDao: RetailerDao) : RetailerRepo {

    override suspend fun insertRetailer(retailer: Retailer) {
        retailerDao.insertRetailer(retailer)
    }

    override suspend fun deleteRetailer(retailer: Retailer) {
        retailerDao.deleteRetailer(retailer)
    }

    override fun getAllRetailers(): Flow<List<Retailer>> {
        return retailerDao.getAllRetailers()
    }

    override fun getRetailerAndUserWithRetailerId(retailerId: Int): Flow<List<RetailerAndUser>> {
        return retailerDao.getRetailerAndUserWithRetailerId(retailerId)
    }

    override fun getRetailerWithOrders(retailerId: Int): Flow<List<RetailerWithOrders>> {
        return retailerDao.getRetailerWithOrders(retailerId)
    }

    override fun getRetailerWithBookings(retailerId: Int): Flow<List<RetailerWithBookings>> {
        return retailerDao.getRetailerWithBookings(retailerId)
    }
}