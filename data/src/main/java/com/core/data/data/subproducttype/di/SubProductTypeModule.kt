package com.core.data.data.subproducttype.di

import com.core.data.PayGoDatabase
import com.core.data.data.subproducttype.dao.SubProductTypeDao
import com.core.data.data.subproducttype.repo.SubProductTypeRepo
import com.core.data.data.subproducttype.repo.SubProductTypeRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SubProductTypeModule {

    @Provides
    @Singleton
    fun provideSubProductTypeDao(db: PayGoDatabase): SubProductTypeDao {
        return db.getSubProductTypeDao()
    }

    @Provides
    @Singleton
    fun provideSubProductTypeRepo(imp: SubProductTypeRepoImp): SubProductTypeRepo {
        return imp
    }
}