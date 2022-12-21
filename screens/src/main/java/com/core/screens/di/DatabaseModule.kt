package com.core.screens.di

import android.content.Context
import androidx.room.Room
import com.core.data.PayGoDatabase
import com.core.utils.constants.Database.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PayGoDatabase =
        Room.databaseBuilder(
            context,
            PayGoDatabase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
}