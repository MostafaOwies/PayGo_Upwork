package com.core.data.data.retailer.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.retailer.api.RetailerApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class RetailerRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val retailerApi: RetailerApi
) : RetailerRemoteDataSource, BaseRemoteDataSource() {


}