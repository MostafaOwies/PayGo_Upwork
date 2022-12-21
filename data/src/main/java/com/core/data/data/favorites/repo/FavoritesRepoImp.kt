package com.core.data.data.favorites.repo

import com.core.data.data.favorites.dao.FavoritesDao
import com.core.domain.entities.Favorites
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRepoImp @Inject constructor(private val favoritesDao: FavoritesDao) : FavoritesRepo {
    override suspend fun insertFavorite(favorites: Favorites) {
        favoritesDao.insertFavorite(favorites)
    }

    override suspend fun deleteFavorites(favorites: Favorites) {
        favoritesDao.deleteFavorites(favorites)
    }

    override fun getAllFavorites(): Flow<List<Favorites>> {
        return favoritesDao.getAllFavorites()
    }

    override fun getFavorite(): Flow<Favorites> {
        return favoritesDao.getFavorite()
    }
}