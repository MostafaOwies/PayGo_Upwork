package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Order
import com.core.domain.entities.Retailer

data class RetailerWithOrders(
    @Embedded val retailer: Retailer,
    @Relation(
        parentColumn = "retailerId",
        entityColumn = "retailerId"
    )
    val orders: List<Order>
)
