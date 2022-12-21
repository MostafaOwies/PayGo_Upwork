package com.core.data.data.action.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.action.api.ActionApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class ActionRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val actionApi: ActionApi
) : ActionRemoteDataSource, BaseRemoteDataSource() {


}