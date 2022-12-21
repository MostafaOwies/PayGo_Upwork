package com.core.domain.relations.manytomany.orderproductwithofferset

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.core.domain.entities.OfferSet
import com.core.domain.entities.OrderProduct

data class OfferSetWithOrderProduct(
    @Embedded val offerSet: OfferSet,
    @Relation(
        parentColumn = "offerSetId",
        entityColumn = "orderProductId",
        associateBy = Junction(OrderProductWithOfferSetCrossRef::class)
    )
    val orderProduct: List<OrderProduct>
)
