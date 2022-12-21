package com.core.data.data.messagenetwork.di

import com.core.data.PayGoDatabase
import com.core.data.data.messagenetwork.dao.MessageNetworkDao
import com.core.data.data.messagenetwork.repo.MessageNetworkRepo
import com.core.data.data.messagenetwork.repo.MessageNetworkRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MessageNetworkModule {

    @Provides
    @Singleton
    fun provideMessageNetworkDao(db: PayGoDatabase): MessageNetworkDao {
        return db.getMessageNetworkDao()
    }

    @Provides
    @Singleton
    fun provideMessageNetworkRepo(messageNetworkRepoImp: MessageNetworkRepoImp): MessageNetworkRepo {
        return messageNetworkRepoImp
    }
}