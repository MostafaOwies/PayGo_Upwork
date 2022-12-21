package com.core.data.data.product.di

import com.core.data.PayGoDatabase
import com.core.data.data.product.dao.ProductDao
import com.core.data.data.product.repo.ProductRepo
import com.core.data.data.product.repo.ProductRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ProductModule {

    @Provides
    @Singleton
    fun provideProductDao(db: PayGoDatabase): ProductDao {
        return db.getProductDao()
    }

    @Provides
    @Singleton
    fun provideProductRepo(imp: ProductRepoImp): ProductRepo {
        return imp
    }
}