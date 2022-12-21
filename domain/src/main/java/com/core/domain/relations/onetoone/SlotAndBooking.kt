package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Booking
import com.core.domain.entities.Slot

data class SlotAndBooking(
    @Embedded val slot: Slot,
    @Relation(
        parentColumn = "slotId",
        entityColumn = "slotId"
    )
    val booking: Booking
)
