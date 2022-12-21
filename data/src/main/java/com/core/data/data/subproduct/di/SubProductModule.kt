package com.core.data.data.subproduct.di

import com.core.data.PayGoDatabase
import com.core.data.data.subproduct.dao.SubProductDao
import com.core.data.data.subproduct.repo.SubProductRepo
import com.core.data.data.subproduct.repo.SubProductRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SubProductModule {

    @Provides
    @Singleton
    fun provideSubProductDao(db: PayGoDatabase): SubProductDao {
        return db.getSubProductDao()
    }

    @Provides
    @Singleton
    fun provideSubProductRepo(imp: SubProductRepoImp): SubProductRepo {
        return imp
    }
}