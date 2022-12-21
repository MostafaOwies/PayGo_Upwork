package com.core.data.data.retailer.repo

import com.core.domain.entities.Retailer
import com.core.domain.relations.onetomany.RetailerWithBookings
import com.core.domain.relations.onetomany.RetailerWithOrders
import com.core.domain.relations.onetoone.RetailerAndUser
import kotlinx.coroutines.flow.Flow

interface RetailerRepo {

    suspend fun insertRetailer(retailer: Retailer)
    suspend fun deleteRetailer(retailer: Retailer)
    fun getAllRetailers(): Flow<List<Retailer>>
    fun getRetailerAndUserWithRetailerId(retailerId: Int): Flow<List<RetailerAndUser>>
    fun getRetailerWithOrders(retailerId: Int): Flow<List<RetailerWithOrders>>
    fun getRetailerWithBookings(retailerId: Int): Flow<List<RetailerWithBookings>>
}