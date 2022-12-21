package com.core.data.data.slot.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.slot.api.SlotApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class SlotRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val slotApi: SlotApi
) : SlotRemoteDataSource, BaseRemoteDataSource() {


}