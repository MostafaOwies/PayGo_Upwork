package com.core.data.data.orderproductstatus.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.orderproductstatus.api.OrderProductStatusApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class OrderProductStatusRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val orderProductStatusApi: OrderProductStatusApi
) : OrderProductStatusRemoteDataSource, BaseRemoteDataSource() {


}