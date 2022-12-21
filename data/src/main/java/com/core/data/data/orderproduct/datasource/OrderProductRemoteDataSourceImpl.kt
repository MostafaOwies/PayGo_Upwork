package com.core.data.data.orderproduct.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.orderproduct.api.OrderProductApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class OrderProductRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val orderProductApi: OrderProductApi
) : OrderProductRemoteDataSource, BaseRemoteDataSource() {


}