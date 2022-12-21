package com.core.data.data.order.di

import com.core.data.PayGoDatabase
import com.core.data.data.order.dao.OrderDao
import com.core.data.data.order.repo.OrderRepo
import com.core.data.data.order.repo.OrderRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OrderModule {

    @Provides
    @Singleton
    fun provideOrderDao(db: PayGoDatabase): OrderDao {
        return db.getOrderDao()
    }

    @Provides
    @Singleton
    fun provideOrderRepo(imp: OrderRepoImp): OrderRepo {
        return imp
    }
}