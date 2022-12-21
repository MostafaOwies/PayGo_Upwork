package com.core.data.data.order.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.order.api.OrderApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class OrderRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val orderApi: OrderApi
) : OrderRemoteDataSource, BaseRemoteDataSource() {


}