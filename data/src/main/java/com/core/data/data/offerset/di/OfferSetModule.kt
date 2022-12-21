package com.core.data.data.offerset.di

import com.core.data.PayGoDatabase
import com.core.data.data.offerset.dao.OfferSetDao
import com.core.data.data.offerset.repo.OfferSetRepo
import com.core.data.data.offerset.repo.OfferSetRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OfferSetModule {

    @Provides
    @Singleton
    fun provideOfferSetDao(db: PayGoDatabase): OfferSetDao {
        return db.getOfferSetDao()
    }

    @Provides
    @Singleton
    fun provideOfferSetRepo(imp: OfferSetRepoImp): OfferSetRepo {
        return imp
    }
}