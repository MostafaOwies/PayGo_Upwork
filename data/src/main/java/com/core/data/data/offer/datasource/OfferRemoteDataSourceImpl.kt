package com.core.data.data.offer.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.offer.api.OfferApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class OfferRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val offerApi: OfferApi
) : OfferRemoteDataSource, BaseRemoteDataSource() {


}