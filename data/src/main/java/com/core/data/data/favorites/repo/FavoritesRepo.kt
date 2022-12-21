package com.core.data.data.favorites.repo

import com.core.domain.entities.Favorites
import kotlinx.coroutines.flow.Flow

interface FavoritesRepo {

    suspend fun insertFavorite(favorites: Favorites)
    suspend fun deleteFavorites(favorites: Favorites)
    fun getAllFavorites(): Flow<List<Favorites>>
    fun getFavorite(): Flow<Favorites>
}