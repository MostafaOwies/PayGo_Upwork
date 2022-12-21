package com.core.data.data.orderstatus.di

import com.core.data.PayGoDatabase
import com.core.data.data.orderstatus.dao.OrderStatusDao
import com.core.data.data.orderstatus.repo.OrderStatusRepo
import com.core.data.data.orderstatus.repo.OrderStatusRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OrderStatusModule {

    @Provides
    @Singleton
    fun provideOrderStatusDao(db: PayGoDatabase): OrderStatusDao {
        return db.getOrderStatusDao()
    }

    @Provides
    @Singleton
    fun provideOrderStatusRepo(imp: OrderStatusRepoImp): OrderStatusRepo {
        return imp
    }
}