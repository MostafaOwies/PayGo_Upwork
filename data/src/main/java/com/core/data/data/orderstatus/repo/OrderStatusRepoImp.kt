package com.core.data.data.orderstatus.repo

import com.core.data.data.orderstatus.dao.OrderStatusDao
import com.core.domain.entities.OrderStatus
import com.core.domain.relations.onetoone.OrderStatusAndOrder
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderStatusRepoImp @Inject constructor(private val orderStatusDao: OrderStatusDao) :
    OrderStatusRepo {
    override suspend fun insertOrderStatus(orderStatus: OrderStatus) {
        orderStatusDao.insertOrderStatus(orderStatus)
    }

    override suspend fun deleteOrderStatus(orderStatus: OrderStatus) {
        orderStatusDao.deleteOrderStatus(orderStatus)
    }

    override fun getAllOrderStatus(): Flow<List<OrderStatus>> {
        return orderStatusDao.getAllOrderStatus()
    }

    override fun getOrderStatusAndOrderWithOrderStatusId(orderStatusId: Int): Flow<List<OrderStatusAndOrder>> {
        return orderStatusDao.getOrderStatusAndOrderWithOrderStatusId(orderStatusId)
    }

}