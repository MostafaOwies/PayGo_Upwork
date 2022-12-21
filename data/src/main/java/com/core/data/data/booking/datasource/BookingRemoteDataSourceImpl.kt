package com.core.data.data.booking.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.booking.api.BookingApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class BookingRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val bookingApi: BookingApi
) : BookingRemoteDataSource, BaseRemoteDataSource() {


}