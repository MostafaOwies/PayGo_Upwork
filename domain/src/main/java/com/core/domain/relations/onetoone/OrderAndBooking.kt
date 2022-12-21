package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Booking
import com.core.domain.entities.Order

data class OrderAndBooking(
    @Embedded val order: Order,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "preOrderId"
    )
    val booking: Booking
)
