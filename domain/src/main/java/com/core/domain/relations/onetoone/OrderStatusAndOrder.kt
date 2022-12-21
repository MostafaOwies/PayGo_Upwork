package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Order
import com.core.domain.entities.OrderStatus

data class OrderStatusAndOrder(
    @Embedded val orderStatus: OrderStatus,
    @Relation(
        parentColumn = "orderStatusId",
        entityColumn = "orderStatusId"
    )
    val order: Order
)
