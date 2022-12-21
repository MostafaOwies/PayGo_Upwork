package com.core.data.data.orderfinance.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.orderfinance.api.OrderFinanceApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class OrderFinanceRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val orderFinanceApi: OrderFinanceApi
) : OrderFinanceRemoteDataSource, BaseRemoteDataSource() {


}