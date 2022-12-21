package com.core.data.data.ros.di

import com.core.data.PayGoDatabase
import com.core.data.data.ros.dao.RosDao
import com.core.data.data.ros.repo.RosRepo
import com.core.data.data.ros.repo.RosRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RosModule {

    @Provides
    @Singleton
    fun provideRosDao(db: PayGoDatabase): RosDao {
        return db.getROSDao()
    }

    @Provides
    @Singleton
    fun provideRosRepo(imp: RosRepoImp): RosRepo {
        return imp
    }
}