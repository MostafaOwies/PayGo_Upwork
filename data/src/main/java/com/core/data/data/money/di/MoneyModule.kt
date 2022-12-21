package com.core.data.data.money.di

import com.core.data.PayGoDatabase
import com.core.data.data.money.dao.MoneyDao
import com.core.data.data.money.repo.MoneyRepo
import com.core.data.data.money.repo.MoneyRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoneyModule {

    @Provides
    @Singleton
    fun provideMoneyDao(db: PayGoDatabase): MoneyDao {
        return db.getMoneyDao()
    }

    @Provides
    @Singleton
    fun provideMoneyRepo(moneyRepoImp: MoneyRepoImp): MoneyRepo {
        return moneyRepoImp
    }
}