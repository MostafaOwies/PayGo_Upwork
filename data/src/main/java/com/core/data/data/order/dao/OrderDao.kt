package com.core.data.data.order.dao

import androidx.room.*
import com.core.domain.entities.Order
import com.core.domain.relations.onetoone.OrderAndBooking
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(vararg order: Order)

    @Delete
    suspend fun deleteOrder(order: Order)

    @Query("SELECT * FROM `order`")
    fun getAllOrders(): Flow<List<Order>>

    @Transaction
    @Query("SELECT * FROM `Order` WHERE orderId = :orderId")
    fun getOrderAndBookingWithOrderId(orderId: Int): Flow<List<OrderAndBooking>>
}