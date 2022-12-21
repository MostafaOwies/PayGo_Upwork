package com.core.data.data.address.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.address.api.AddressApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class AddressRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val addressApi: AddressApi
) : AddressRemoteDataSource, BaseRemoteDataSource() {


}