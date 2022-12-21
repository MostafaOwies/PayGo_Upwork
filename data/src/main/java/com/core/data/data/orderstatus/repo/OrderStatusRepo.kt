package com.core.data.data.orderstatus.repo

import com.core.domain.entities.OrderStatus
import com.core.domain.relations.onetoone.OrderStatusAndOrder
import kotlinx.coroutines.flow.Flow

interface OrderStatusRepo {

    suspend fun insertOrderStatus(orderStatus: OrderStatus)
    suspend fun deleteOrderStatus(orderStatus: OrderStatus)
    fun getAllOrderStatus(): Flow<List<OrderStatus>>
    fun getOrderStatusAndOrderWithOrderStatusId(orderStatusId: Int): Flow<List<OrderStatusAndOrder>>
}