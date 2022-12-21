package com.core.data.data.discount.di

import com.core.data.PayGoDatabase
import com.core.data.data.discount.dao.DiscountDao
import com.core.data.data.discount.repo.DiscountRepo
import com.core.data.data.discount.repo.DiscountRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DiscountModule {

    @Provides
    @Singleton
    fun provideDiscountDao(db: PayGoDatabase): DiscountDao {
        return db.getDiscountDao()
    }

    @Provides
    @Singleton
    fun provideDiscountRepo(discountRepoImp: DiscountRepoImp): DiscountRepo {
        return discountRepoImp
    }
}