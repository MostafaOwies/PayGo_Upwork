package com.core.data.data.order.repo

import com.core.domain.entities.Order
import com.core.domain.relations.onetoone.OrderAndBooking
import kotlinx.coroutines.flow.Flow

interface OrderRepo {

    suspend fun insertOrder(order: Order)
    suspend fun deleteOrder(order: Order)
    fun getAllOrders(): Flow<List<Order>>
    fun getOrderAndBookingWithOrderId(orderId: Int): Flow<List<OrderAndBooking>>
}