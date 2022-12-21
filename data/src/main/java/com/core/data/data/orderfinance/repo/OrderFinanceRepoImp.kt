package com.core.data.data.orderfinance.repo

import com.core.data.data.orderfinance.dao.OrderFinanceDao
import com.core.domain.entities.OrderFinance
import com.core.domain.relations.onetoone.OrderFinanceAndOrder
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderFinanceRepoImp @Inject constructor(private val orderFinanceDao: OrderFinanceDao) :
    OrderFinanceRepo {

    override suspend fun insertOrderFinance(orderFinance: OrderFinance) {
        orderFinanceDao.insertOrderFinance(orderFinance)
    }

    override suspend fun deleteOrderFinance(orderFinance: OrderFinance) {
        orderFinanceDao.deleteOrderFinance(orderFinance)
    }

    override fun getAllOrderFinances(): Flow<List<OrderFinance>> {
        return orderFinanceDao.getAllOrderFinances()
    }

    override fun getOrderFinanceAndOrderWithOrderFinanceId(orderFinanceId: Int): Flow<List<OrderFinanceAndOrder>> {
        return orderFinanceDao.getOrderFinanceAndOrderWithOrderFinanceId(orderFinanceId)
    }
}