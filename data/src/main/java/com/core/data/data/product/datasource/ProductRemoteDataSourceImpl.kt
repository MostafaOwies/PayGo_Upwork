package com.core.data.data.product.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.product.api.ProductApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class ProductRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val productApi: ProductApi
) : ProductRemoteDataSource, BaseRemoteDataSource() {


}