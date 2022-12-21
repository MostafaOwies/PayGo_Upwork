package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Order
import com.core.domain.entities.Slot

data class SlotAndOrder(
    @Embedded val slot: Slot,
    @Relation(
        parentColumn = "slotId",
        entityColumn = "slotId"
    )
    val order: Order
)
