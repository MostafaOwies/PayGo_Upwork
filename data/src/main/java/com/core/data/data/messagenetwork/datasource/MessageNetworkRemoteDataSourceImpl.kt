package com.core.data.data.messagenetwork.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.messagenetwork.api.MessageNetworkApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class MessageNetworkRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val messageNetworkApi: MessageNetworkApi
) : MessageNetworkRemoteDataSource, BaseRemoteDataSource() {


}