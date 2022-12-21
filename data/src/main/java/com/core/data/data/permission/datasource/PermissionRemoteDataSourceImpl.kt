package com.core.data.data.permission.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.permission.api.PermissionApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class PermissionRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val permissionApi: PermissionApi
) : PermissionRemoteDataSource, BaseRemoteDataSource() {


}