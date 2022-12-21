package com.core.data.data.offerset.repo

import com.core.data.data.offerset.dao.OfferSetDao
import com.core.domain.entities.OfferSet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfferSetRepoImp @Inject constructor(private val offerSetDao: OfferSetDao) : OfferSetRepo {

    override suspend fun insertOfferSet(offerSet: OfferSet) {
        offerSetDao.insertOfferSet(offerSet)
    }

    override suspend fun deleteOfferSet(offerSet: OfferSet) {
        offerSetDao.deleteOfferSet(offerSet)
    }

    override fun getAllOfferSets(): Flow<List<OfferSet>> {
        return offerSetDao.getAllOfferSets()
    }
}