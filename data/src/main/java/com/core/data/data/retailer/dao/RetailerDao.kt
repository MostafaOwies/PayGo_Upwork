package com.core.data.data.retailer.dao

import androidx.room.*
import com.core.domain.entities.Retailer
import com.core.domain.relations.onetomany.RetailerWithBookings
import com.core.domain.relations.onetomany.RetailerWithOrders
import com.core.domain.relations.onetoone.RetailerAndUser
import kotlinx.coroutines.flow.Flow

@Dao
interface RetailerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRetailer(vararg retailer: Retailer)

    @Delete
    suspend fun deleteRetailer(retailer: Retailer)

    @Query("SELECT * FROM Retailer")
    fun getAllRetailers(): Flow<List<Retailer>>

    @Transaction
    @Query("SELECT * FROM Retailer WHERE retailerId = :retailerId")
    fun getRetailerAndUserWithRetailerId(retailerId: Int): Flow<List<RetailerAndUser>>

    @Transaction
    @Query("SELECT * FROM Retailer WHERE retailerId = :retailerId")
    fun getRetailerWithOrders(retailerId: Int): Flow<List<RetailerWithOrders>>

    @Transaction
    @Query("SELECT * FROM Retailer WHERE retailerId = :retailerId")
    fun getRetailerWithBookings(retailerId: Int): Flow<List<RetailerWithBookings>>
}