package com.core.domain.relations.manytomany.orderproductwithofferset

import androidx.room.Entity

@Entity(primaryKeys = ["orderProductId", "offerSetId"])
data class OrderProductWithOfferSetCrossRef(
    var orderProductId: Int = 0,
    var offerSetId: Int = 0
)
