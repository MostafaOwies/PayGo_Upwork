package com.core.data.data.orderfinance.repo

import com.core.domain.entities.OrderFinance
import com.core.domain.relations.onetoone.OrderFinanceAndOrder
import kotlinx.coroutines.flow.Flow

interface OrderFinanceRepo {

    suspend fun insertOrderFinance(orderFinance: OrderFinance)
    suspend fun deleteOrderFinance(orderFinance: OrderFinance)
    fun getAllOrderFinances(): Flow<List<OrderFinance>>
    fun getOrderFinanceAndOrderWithOrderFinanceId(orderFinanceId: Int): Flow<List<OrderFinanceAndOrder>>
}