package com.core.data.data.orderproductstatus.repo

import com.core.data.data.orderproductstatus.dao.OrderProductStatusDao
import com.core.domain.entities.OrderProductStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderProductStatusRepoImp @Inject constructor(private val orderProductStatusDao: OrderProductStatusDao) :
    OrderProductStatusRepo {

    override suspend fun insertOrderProductStatus(orderProductStatus: OrderProductStatus) {
        orderProductStatusDao.insertOrderProductStatus(orderProductStatus)
    }

    override suspend fun deleteOrderProductStatus(orderProductStatus: OrderProductStatus) {
        orderProductStatusDao.deleteOrderProductStatus(orderProductStatus)
    }

    override fun getAllOrderProductStatus(): Flow<List<OrderProductStatus>> {
        return orderProductStatusDao.getAllOrderProductStatus()
    }
}