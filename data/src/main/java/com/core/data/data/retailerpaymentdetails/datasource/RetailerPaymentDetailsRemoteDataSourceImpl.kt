package com.core.data.data.retailerpaymentdetails.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.retailerpaymentdetails.api.RetailerPaymentDetailsApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class RetailerPaymentDetailsRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val retailerPaymentDetailsApi: RetailerPaymentDetailsApi
) : RetailerPaymentDetailsRemoteDataSource, BaseRemoteDataSource() {


}