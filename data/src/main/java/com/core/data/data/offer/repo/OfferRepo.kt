package com.core.data.data.offer.repo

import com.core.domain.entities.Offer
import com.core.domain.relations.onetomany.OfferWithOfferSet
import kotlinx.coroutines.flow.Flow

interface OfferRepo {

    suspend fun insertOffer(offer: Offer)
    suspend fun deleteOffer(offer: Offer)
    fun getAllOffers(): Flow<List<Offer>>
    fun getOfferWithOfferSet(offerId: Int): Flow<List<OfferWithOfferSet>>

}