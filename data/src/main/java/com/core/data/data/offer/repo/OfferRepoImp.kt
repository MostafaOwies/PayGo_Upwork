package com.core.data.data.offer.repo

import com.core.data.data.offer.dao.OfferDao
import com.core.domain.entities.Offer
import com.core.domain.relations.onetomany.OfferWithOfferSet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfferRepoImp @Inject constructor(private val offerDao: OfferDao) : OfferRepo {
    override suspend fun insertOffer(offer: Offer) {
        offerDao.insertOffer(offer)
    }

    override suspend fun deleteOffer(offer: Offer) {
        offerDao.deleteOffer(offer)
    }

    override fun getAllOffers(): Flow<List<Offer>> {
        return offerDao.getAllOffers()
    }

    override fun getOfferWithOfferSet(offerId: Int): Flow<List<OfferWithOfferSet>> {
        return offerDao.getOfferWithOfferSet(offerId)
    }
}