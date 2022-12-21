package com.core.data.data.orderproduct.di

import com.core.data.PayGoDatabase
import com.core.data.data.orderproduct.dao.OrderProductDao
import com.core.data.data.orderproduct.repo.OrderProductRepo
import com.core.data.data.orderproduct.repo.OrderProductRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OrderProductModule {

    @Provides
    @Singleton
    fun provideOrderProductDao(db: PayGoDatabase): OrderProductDao {
        return db.getOrderProductDao()
    }

    @Provides
    @Singleton
    fun provideOrderProductRepo(imp: OrderProductRepoImp): OrderProductRepo {
        return imp

    }
}