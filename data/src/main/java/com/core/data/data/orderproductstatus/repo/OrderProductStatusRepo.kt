package com.core.data.data.orderproductstatus.repo


import com.core.domain.entities.OrderProductStatus
import kotlinx.coroutines.flow.Flow

interface OrderProductStatusRepo {

    suspend fun insertOrderProductStatus(orderProductStatus: OrderProductStatus)
    suspend fun deleteOrderProductStatus(orderProductStatus: OrderProductStatus)
    fun getAllOrderProductStatus(): Flow<List<OrderProductStatus>>
}