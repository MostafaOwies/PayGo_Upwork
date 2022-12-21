package com.core.data.data.orderproduct.repo

import com.core.data.data.orderproduct.dao.OrderProductDao
import com.core.domain.entities.OrderProduct
import com.core.domain.relations.manytomany.orderproductwithofferset.OfferSetWithOrderProduct
import com.core.domain.relations.manytomany.orderproductwithofferset.OrderProductWithOfferSet
import com.core.domain.relations.manytomany.orderproductwithofferset.OrderProductWithOfferSetCrossRef
import com.core.domain.relations.manytomany.orderproductwithsubproduct.OrderProductWithSubProduct
import com.core.domain.relations.manytomany.orderproductwithsubproduct.OrderProductWithSubProductCrossRef
import com.core.domain.relations.manytomany.orderproductwithsubproduct.SubProductWithOrderProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderProductRepoImp @Inject constructor(private val orderProductDao: OrderProductDao) :
    OrderProductRepo {

    override suspend fun insertOrderProduct(orderProduct: OrderProduct) {
        orderProductDao.insertOrderProduct(orderProduct)
    }

    override suspend fun insertOrderProductOfferSetCrossRef(crossRef: OrderProductWithOfferSetCrossRef) {
        orderProductDao.insertOrderProductOfferSetCrossRef(crossRef)
    }

    override suspend fun insertOrderProductSubProductCrossRef(crossRef: OrderProductWithSubProductCrossRef) {
        orderProductDao.insertOrderProductSubProductCrossRef(crossRef)
    }

    override suspend fun deleteOrderProduct(orderProduct: OrderProduct) {
        orderProductDao.deleteOrderProduct(orderProduct)
    }

    override fun getAllOrderProducts(): Flow<List<OrderProduct>> {
        return orderProductDao.getAllOrderProducts()
    }

    override fun getOfferSetsOfOrderProduct(orderProductId: Int): Flow<List<OrderProductWithOfferSet>> {
        return orderProductDao.getOfferSetsOfOrderProduct(orderProductId)
    }

    override fun getOrderProductsOfOfferSet(offerSetId: Int): Flow<List<OfferSetWithOrderProduct>> {
        return orderProductDao.getOrderProductsOfOfferSet(offerSetId)
    }

    override fun getSubProductsOfOrderProduct(orderProductId: Int): Flow<List<OrderProductWithSubProduct>> {
        return orderProductDao.getSubProductsOfOrderProduct(orderProductId)
    }

    override fun getOrderProductsOfSubProduct(subProductId: Int): Flow<List<SubProductWithOrderProduct>> {
        return orderProductDao.getOrderProductsOfSubProduct(subProductId)
    }
}