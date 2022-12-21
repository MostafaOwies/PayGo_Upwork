package com.core.data.data.orderfinance.di

import com.core.data.PayGoDatabase
import com.core.data.data.orderfinance.dao.OrderFinanceDao
import com.core.data.data.orderfinance.repo.OrderFinanceRepo
import com.core.data.data.orderfinance.repo.OrderFinanceRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OrderFinanceModule {

    @Provides
    @Singleton
    fun provideOrderFinanceDao(db: PayGoDatabase): OrderFinanceDao {
        return db.getOrderFinanceDao()
    }

    @Provides
    @Singleton
    fun provideOrderFinanceRepo(imp: OrderFinanceRepoImp): OrderFinanceRepo {
        return imp
    }
}