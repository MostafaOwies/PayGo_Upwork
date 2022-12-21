package com.core.data.data.paymentintegration.di

import com.core.data.PayGoDatabase
import com.core.data.data.paymentintegration.dao.PaymentIntegrationDao
import com.core.data.data.paymentintegration.repo.PaymentIntegrationRepo
import com.core.data.data.paymentintegration.repo.PaymentIntegrationRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PaymentIntegrationModule {

    @Provides
    @Singleton
    fun providePaymentIntDao(db: PayGoDatabase): PaymentIntegrationDao {
        return db.getPaymentIntegrationDao()
    }

    @Provides
    @Singleton
    fun providePaymentIntRepo(imp: PaymentIntegrationRepoImp): PaymentIntegrationRepo {
        return imp
    }
}