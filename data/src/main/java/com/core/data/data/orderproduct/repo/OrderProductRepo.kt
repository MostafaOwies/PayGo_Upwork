package com.core.data.data.orderproduct.repo

import com.core.domain.entities.OrderProduct
import com.core.domain.relations.manytomany.orderproductwithofferset.OfferSetWithOrderProduct
import com.core.domain.relations.manytomany.orderproductwithofferset.OrderProductWithOfferSet
import com.core.domain.relations.manytomany.orderproductwithofferset.OrderProductWithOfferSetCrossRef
import com.core.domain.relations.manytomany.orderproductwithsubproduct.OrderProductWithSubProduct
import com.core.domain.relations.manytomany.orderproductwithsubproduct.OrderProductWithSubProductCrossRef
import com.core.domain.relations.manytomany.orderproductwithsubproduct.SubProductWithOrderProduct
import kotlinx.coroutines.flow.Flow

interface OrderProductRepo {

    suspend fun insertOrderProduct(orderProduct: OrderProduct)
    suspend fun insertOrderProductOfferSetCrossRef(crossRef: OrderProductWithOfferSetCrossRef)
    suspend fun insertOrderProductSubProductCrossRef(crossRef: OrderProductWithSubProductCrossRef)
    suspend fun deleteOrderProduct(orderProduct: OrderProduct)

    fun getAllOrderProducts(): Flow<List<OrderProduct>>
    fun getOfferSetsOfOrderProduct(orderProductId: Int): Flow<List<OrderProductWithOfferSet>>
    fun getOrderProductsOfOfferSet(offerSetId: Int): Flow<List<OfferSetWithOrderProduct>>
    fun getSubProductsOfOrderProduct(orderProductId: Int): Flow<List<OrderProductWithSubProduct>>
    fun getOrderProductsOfSubProduct(subProductId: Int): Flow<List<SubProductWithOrderProduct>>
}