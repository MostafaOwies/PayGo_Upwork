package com.core.data.data.user.di

import com.core.data.PayGoDatabase
import com.core.data.data.user.dao.UserDao
import com.core.data.data.user.repo.UserRepo
import com.core.data.data.user.repo.UserRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Provides
    @Singleton
    fun provideUserDao(db: PayGoDatabase): UserDao {
        return db.getUserDao()
    }

    @Provides
    @Singleton
    fun provideUserRepo(imp: UserRepoImp): UserRepo {
        return imp
    }
}