package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Order
import com.core.domain.entities.OrderProduct

data class OrderWithOrderProduct(
    @Embedded val order: Order,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "orderId"
    )

    val orderProduct: List<OrderProduct>
)
