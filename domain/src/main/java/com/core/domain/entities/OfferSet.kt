package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OfferSet(

    @PrimaryKey
    var offerSetId: Int = 0,

    var offerId: Int = 0,
    var name: String = "",
    var minItems: Int = 0,
    var maxItems: Int = 0,
)
