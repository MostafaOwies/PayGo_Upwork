package com.core.data.data.orderproductstatus.dao

import androidx.room.*
import com.core.domain.entities.OrderProductStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderProductStatusDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderProductStatus(vararg orderProductStatus: OrderProductStatus)

    @Delete
    suspend fun deleteOrderProductStatus(orderProductStatus: OrderProductStatus)

    @Query("SELECT * FROM `OrderProductStatus`")
    fun getAllOrderProductStatus(): Flow<List<OrderProductStatus>>
}