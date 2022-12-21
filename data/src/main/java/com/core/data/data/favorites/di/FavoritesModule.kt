package com.core.data.data.favorites.di

import com.core.data.PayGoDatabase
import com.core.data.data.favorites.dao.FavoritesDao
import com.core.data.data.favorites.repo.FavoritesRepo
import com.core.data.data.favorites.repo.FavoritesRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FavoritesModule {

    @Provides
    @Singleton
    fun provideFavoritesDao(db :PayGoDatabase) :FavoritesDao{
        return db.getFavoritesDao()
    }

    @Provides
    @Singleton
    fun provideFavoritesRepo(imp :FavoritesRepoImp) :FavoritesRepo {
        return imp
    }
}