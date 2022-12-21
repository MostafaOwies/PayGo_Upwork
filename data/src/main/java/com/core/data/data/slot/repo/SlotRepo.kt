package com.core.data.data.slot.repo

import com.core.domain.entities.Slot
import com.core.domain.relations.onetoone.SlotAndBooking
import com.core.domain.relations.onetoone.SlotAndOrder
import kotlinx.coroutines.flow.Flow

interface SlotRepo {

    suspend fun insertSlot(slot: Slot)
    suspend fun deleteSlot(slot: Slot)
    fun getAllSlots(): Flow<List<Slot>>
    fun getSlotAndOrderWithSlotId(slotId: Int): Flow<List<SlotAndOrder>>
    fun getSlotAndBookingWithSlotId(slotId: Int): Flow<List<SlotAndBooking>>
}