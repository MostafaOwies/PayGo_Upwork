package com.core.data.data.money.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.money.api.MoneyApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class MoneyRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val moneyApi: MoneyApi
) : MoneyRemoteDataSource, BaseRemoteDataSource() {


}