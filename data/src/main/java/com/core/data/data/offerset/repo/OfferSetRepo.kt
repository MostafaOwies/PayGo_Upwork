package com.core.data.data.offerset.repo


import com.core.domain.entities.OfferSet
import kotlinx.coroutines.flow.Flow

interface OfferSetRepo {

    suspend fun insertOfferSet(offerSet: OfferSet)
    suspend fun deleteOfferSet(offerSet: OfferSet)
    fun getAllOfferSets(): Flow<List<OfferSet>>
}