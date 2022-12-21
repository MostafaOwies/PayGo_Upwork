package com.core.data.data.favorites.dao

import androidx.room.*
import com.core.domain.entities.Favorites
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(vararg favorites: Favorites)

    @Delete
    suspend fun deleteFavorites(favorites: Favorites)

    @Query("SELECT * FROM Favorites")
    fun getAllFavorites(): Flow<List<Favorites>>

    @Query("SELECT * FROM Favorites")
    fun getFavorite(): Flow<Favorites>
}