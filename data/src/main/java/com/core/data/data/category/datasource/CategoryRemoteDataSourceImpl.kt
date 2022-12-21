package com.core.data.data.category.datasource

import com.core.base.BaseRemoteDataSource
import com.core.data.data.category.api.CategoryApi
import com.core.utils.NetworkHandler
import javax.inject.Inject


class CategoryRemoteDataSourceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val categoryApi: CategoryApi
) : CategoryRemoteDataSource, BaseRemoteDataSource() {


}