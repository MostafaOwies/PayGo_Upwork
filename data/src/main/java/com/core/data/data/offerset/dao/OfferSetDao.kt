package com.core.data.data.offerset.dao

import androidx.room.*
import com.core.domain.entities.OfferSet
import kotlinx.coroutines.flow.Flow

@Dao
interface OfferSetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOfferSet(vararg offerSet: OfferSet)

    @Delete
    suspend fun deleteOfferSet(offerSet: OfferSet)

    @Query("SELECT * FROM `OfferSet`")
    fun getAllOfferSets(): Flow<List<OfferSet>>
}