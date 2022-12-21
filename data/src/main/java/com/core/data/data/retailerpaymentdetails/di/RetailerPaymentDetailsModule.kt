package com.core.data.data.retailerpaymentdetails.di

import com.core.data.PayGoDatabase
import com.core.data.data.retailerpaymentdetails.dao.RetailerPaymentDetailsDao
import com.core.data.data.retailerpaymentdetails.repo.RetailerPaymentDetailsRepo
import com.core.data.data.retailerpaymentdetails.repo.RetailerPaymentDetailsRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetailerPaymentDetailsModule {

    @Provides
    @Singleton
    fun provideRetailerPaymentDetailsDao(db: PayGoDatabase): RetailerPaymentDetailsDao {
        return db.getRetailerPaymentDetailsDao()
    }

    @Provides
    @Singleton
    fun provideRetailerPaymentDetailsRepo(imp: RetailerPaymentDetailsRepoImp): RetailerPaymentDetailsRepo {
        return imp
    }
}