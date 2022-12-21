package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Offer
import com.core.domain.entities.OfferSet

data class OfferWithOfferSet(
    @Embedded val offer: Offer,
    @Relation(
        parentColumn = "offerId",
        entityColumn = "offerId"
    )
    val offerSet: List<OfferSet>
)
