package com.core.data.data.order.repo

import com.core.data.data.order.dao.OrderDao
import com.core.domain.entities.Order
import com.core.domain.relations.onetoone.OrderAndBooking
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderRepoImp @Inject constructor(private val orderDao: OrderDao) : OrderRepo {

    override suspend fun insertOrder(order: Order) {
        return orderDao.insertOrder(order)
    }

    override suspend fun deleteOrder(order: Order) {
        return orderDao.deleteOrder(order)
    }

    override fun getAllOrders(): Flow<List<Order>> {
        return orderDao.getAllOrders()
    }

    override fun getOrderAndBookingWithOrderId(orderId: Int): Flow<List<OrderAndBooking>> {
        return orderDao.getOrderAndBookingWithOrderId(orderId)
    }
}