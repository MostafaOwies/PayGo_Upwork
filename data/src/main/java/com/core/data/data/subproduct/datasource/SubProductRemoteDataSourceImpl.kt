package com.core.data.data.subproduct.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.subproduct.api.SubProductApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class SubProductRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val subProductApi: SubProductApi
) : SubProductRemoteDataSource, BaseRemoteDataSource() {


}