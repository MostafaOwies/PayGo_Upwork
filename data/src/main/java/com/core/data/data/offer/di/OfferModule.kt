package com.core.data.data.offer.di

import com.core.data.PayGoDatabase
import com.core.data.data.offer.dao.OfferDao
import com.core.data.data.offer.repo.OfferRepo
import com.core.data.data.offer.repo.OfferRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OfferModule {

    @Provides
    @Singleton
    fun provideOfferDao(db: PayGoDatabase): OfferDao {
        return db.getOfferDao()
    }

    @Provides
    @Singleton
    fun provideOfferRepo(imp: OfferRepoImp): OfferRepo {
        return imp
    }
}