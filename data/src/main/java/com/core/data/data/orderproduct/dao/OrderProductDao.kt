package com.core.data.data.orderproduct.dao

import androidx.room.*
import com.core.domain.entities.OrderProduct
import com.core.domain.relations.manytomany.orderproductwithofferset.OfferSetWithOrderProduct
import com.core.domain.relations.manytomany.orderproductwithofferset.OrderProductWithOfferSet
import com.core.domain.relations.manytomany.orderproductwithofferset.OrderProductWithOfferSetCrossRef
import com.core.domain.relations.manytomany.orderproductwithsubproduct.OrderProductWithSubProduct
import com.core.domain.relations.manytomany.orderproductwithsubproduct.OrderProductWithSubProductCrossRef
import com.core.domain.relations.manytomany.orderproductwithsubproduct.SubProductWithOrderProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderProduct(vararg orderProduct: OrderProduct)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderProductOfferSetCrossRef(crossRef: OrderProductWithOfferSetCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderProductSubProductCrossRef(crossRef: OrderProductWithSubProductCrossRef)

    @Delete
    suspend fun deleteOrderProduct(orderProduct: OrderProduct)

    @Query("SELECT * FROM `OrderProduct`")
    fun getAllOrderProducts(): Flow<List<OrderProduct>>

    @Transaction
    @Query("SELECT * FROM OrderProduct WHERE orderProductId = :orderProductId")
    fun getOfferSetsOfOrderProduct(orderProductId: Int): Flow<List<OrderProductWithOfferSet>>

    @Transaction
    @Query("SELECT * FROM OfferSet WHERE offerSetId = :offerSetId")
    fun getOrderProductsOfOfferSet(offerSetId: Int): Flow<List<OfferSetWithOrderProduct>>


    @Transaction
    @Query("SELECT * FROM OrderProduct WHERE orderProductId = :orderProductId")
    fun getSubProductsOfOrderProduct(orderProductId: Int): Flow<List<OrderProductWithSubProduct>>

    @Transaction
    @Query("SELECT * FROM SubProduct WHERE subProductId = :subProductId")
    fun getOrderProductsOfSubProduct(subProductId: Int): Flow<List<SubProductWithOrderProduct>>
}