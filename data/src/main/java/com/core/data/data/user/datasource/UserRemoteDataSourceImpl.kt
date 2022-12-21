package com.core.data.data.user.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.user.api.UserApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class UserRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val userApi: UserApi
) : UserRemoteDataSource, BaseRemoteDataSource() {


}