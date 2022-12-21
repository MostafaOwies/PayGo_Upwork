package com.core.data.data.slot.di

import com.core.data.PayGoDatabase
import com.core.data.data.slot.dao.SlotDao
import com.core.data.data.slot.repo.SlotRepo
import com.core.data.data.slot.repo.SlotRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SlotModule {

    @Provides
    @Singleton
    fun provideSlotDao(db: PayGoDatabase): SlotDao {
        return db.getSlotDao()
    }

    @Provides
    @Singleton
    fun provideSlotREpo(imp: SlotRepoImp): SlotRepo {
        return imp
    }
}