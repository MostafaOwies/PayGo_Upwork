package com.core.data.data.ros.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.ros.api.RosApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class RosRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val rosApi: RosApi
) : RosRemoteDataSource, BaseRemoteDataSource() {


}