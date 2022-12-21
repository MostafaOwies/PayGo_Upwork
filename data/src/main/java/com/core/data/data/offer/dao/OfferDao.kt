package com.core.data.data.offer.dao

import androidx.room.*
import com.core.domain.entities.Offer
import com.core.domain.relations.onetomany.OfferWithOfferSet
import kotlinx.coroutines.flow.Flow

@Dao
interface OfferDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffer(vararg offer: Offer)

    @Delete
    suspend fun deleteOffer(offer: Offer)

    @Query("SELECT * FROM `Offer`")
    fun getAllOffers(): Flow<List<Offer>>

    @Transaction
    @Query("SELECT * FROM Offer WHERE offerId = :offerId")
    fun getOfferWithOfferSet(offerId: Int): Flow<List<OfferWithOfferSet>>
}