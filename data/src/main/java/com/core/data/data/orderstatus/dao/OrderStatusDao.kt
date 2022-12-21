package com.core.data.data.orderstatus.dao

import androidx.room.*
import com.core.domain.entities.OrderStatus
import com.core.domain.relations.onetoone.OrderStatusAndOrder
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderStatusDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderStatus(vararg orderStatus: OrderStatus)

    @Delete
    suspend fun deleteOrderStatus(orderStatus: OrderStatus)

    @Query("SELECT * FROM OrderStatus")
    fun getAllOrderStatus(): Flow<List<OrderStatus>>

    @Transaction
    @Query("SELECT * FROM OrderStatus WHERE orderStatusId = :orderStatusId")
    fun getOrderStatusAndOrderWithOrderStatusId(orderStatusId: Int): Flow<List<OrderStatusAndOrder>>
}