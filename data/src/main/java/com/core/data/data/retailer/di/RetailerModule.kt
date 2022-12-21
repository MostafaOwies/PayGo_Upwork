package com.core.data.data.retailer.di

import com.core.data.PayGoDatabase
import com.core.data.data.retailer.dao.RetailerDao
import com.core.data.data.retailer.repo.RetailerRepo
import com.core.data.data.retailer.repo.RetailerRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetailerModule {

    @Provides
    @Singleton
    fun provideRetailerDao(db: PayGoDatabase): RetailerDao {
        return db.getRetailerDao()
    }

    @Provides
    @Singleton
    fun provideRetailerRepo(imp: RetailerRepoImp): RetailerRepo {
        return imp
    }
}