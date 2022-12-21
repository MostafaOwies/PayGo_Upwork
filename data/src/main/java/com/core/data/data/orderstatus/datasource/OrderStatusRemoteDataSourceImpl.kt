package com.core.data.data.orderstatus.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.orderstatus.api.OrderStatusApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class OrderStatusRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val orderStatusApi: OrderStatusApi
) : OrderStatusRemoteDataSource, BaseRemoteDataSource() {


}