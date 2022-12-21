package com.core.data.data.subproducttype.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.subproducttype.api.SubProductTypeApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class SubProductTypeRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val subProductTypeApi: SubProductTypeApi
) : SubProductTypeRemoteDataSource, BaseRemoteDataSource() {


}