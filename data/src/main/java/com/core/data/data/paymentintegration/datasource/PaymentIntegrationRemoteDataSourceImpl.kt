package com.core.data.data.paymentintegration.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.paymentintegration.api.PaymentIntegrationApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class PaymentIntegrationRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val paymentIntegrationApi: PaymentIntegrationApi
) : PaymentIntegrationRemoteDataSource, BaseRemoteDataSource() {


}