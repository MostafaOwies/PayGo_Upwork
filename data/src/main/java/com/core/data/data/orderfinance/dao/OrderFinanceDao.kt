package com.core.data.data.orderfinance.dao

import androidx.room.*
import com.core.domain.entities.OrderFinance
import com.core.domain.relations.onetoone.OrderFinanceAndOrder
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderFinanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderFinance(vararg orderFinance: OrderFinance)

    @Delete
    suspend fun deleteOrderFinance(orderFinance: OrderFinance)

    @Query("SELECT * FROM OrderFinance")
    fun getAllOrderFinances(): Flow<List<OrderFinance>>

    @Transaction
    @Query("SELECT * FROM OrderFinance WHERE orderFinanceId = :orderFinanceId")
    fun getOrderFinanceAndOrderWithOrderFinanceId(orderFinanceId: Int): Flow<List<OrderFinanceAndOrder>>
}