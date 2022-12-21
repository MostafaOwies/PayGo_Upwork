package com.core.data.data.discount.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.discount.api.DiscountApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class DiscountRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val discountApi: DiscountApi
) : DiscountRemoteDataSource, BaseRemoteDataSource() {


}