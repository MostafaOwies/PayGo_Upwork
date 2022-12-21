package com.core.data.data.orderproductstatus.di

import com.core.data.PayGoDatabase
import com.core.data.data.orderproductstatus.dao.OrderProductStatusDao
import com.core.data.data.orderproductstatus.repo.OrderProductStatusRepo
import com.core.data.data.orderproductstatus.repo.OrderProductStatusRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OrderProductStatusModule {

    @Provides
    @Singleton
    fun provideOrderProductStatusDao(db: PayGoDatabase): OrderProductStatusDao {
        return db.getOrderProductStatusDao()
    }

    @Provides
    @Singleton
    fun provideOrderProductStatusRepo(imp: OrderProductStatusRepoImp): OrderProductStatusRepo {
        return imp
    }
}