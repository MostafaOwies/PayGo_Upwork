package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Booking
import com.core.domain.entities.Retailer

data class RetailerWithBookings(
    @Embedded val retailer: Retailer,
    @Relation(
        parentColumn = "retailerId",
        entityColumn = "retailerId"
    )

    val bookings: List<Booking>
)
