package com.core.data.data.permission.di

import com.core.data.PayGoDatabase
import com.core.data.data.permission.dao.PermissionDao
import com.core.data.data.permission.repo.PermissionRepo
import com.core.data.data.permission.repo.PermissionRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PermissionModule {

    @Provides
    @Singleton
    fun providePermissionDao(db: PayGoDatabase): PermissionDao {
        return db.getPermissionDao()
    }

    @Provides
    @Singleton
    fun providePermissionRepo(imp: PermissionRepoImp): PermissionRepo {
        return imp
    }
}