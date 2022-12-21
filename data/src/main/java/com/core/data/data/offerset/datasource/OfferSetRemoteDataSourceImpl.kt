package com.core.data.data.offerset.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.offerset.api.OfferSetApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class OfferSetRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val offerSetApi: OfferSetApi
) : OfferSetRemoteDataSource, BaseRemoteDataSource() {


}