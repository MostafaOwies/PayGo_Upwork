package com.core.data.data.action.di

import com.core.data.PayGoDatabase
import com.core.data.data.action.dao.ActionDao
import com.core.data.data.action.repo.ActionRepo
import com.core.data.data.action.repo.ActionRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ActionModule {

    @Provides
    @Singleton
    fun provideActionDao(db: PayGoDatabase): ActionDao {
        return db.getActionDao()
    }

    @Provides
    @Singleton
    fun provideActionRepo(actionRepoImp: ActionRepoImp): ActionRepo {
        return actionRepoImp
    }
}