package com.core.domain.relations.manytomany.orderproductwithofferset

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.core.domain.entities.OfferSet
import com.core.domain.entities.OrderProduct

data class OrderProductWithOfferSet(
    @Embedded val orderProduct: OrderProduct,
    @Relation(
        parentColumn = "orderProductId",
        entityColumn = "offerSetId",
        associateBy = Junction(OrderProductWithOfferSetCrossRef::class)
    )
    val offerSet: List<OfferSet>
)
