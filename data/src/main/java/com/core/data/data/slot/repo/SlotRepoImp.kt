package com.core.data.data.slot.repo

import com.core.data.data.slot.dao.SlotDao
import com.core.domain.entities.Slot
import com.core.domain.relations.onetoone.SlotAndBooking
import com.core.domain.relations.onetoone.SlotAndOrder
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SlotRepoImp @Inject constructor(private val slotDao: SlotDao) : SlotRepo {
    override suspend fun insertSlot(slot: Slot) {
        slotDao.insertSlot(slot)
    }

    override suspend fun deleteSlot(slot: Slot) {
        slotDao.deleteSlot(slot)
    }

    override fun getAllSlots(): Flow<List<Slot>> {
        return slotDao.getAllSlots()
    }

    override fun getSlotAndOrderWithSlotId(slotId: Int): Flow<List<SlotAndOrder>> {
        return slotDao.getSlotAndOrderWithSlotId(slotId)
    }

    override fun getSlotAndBookingWithSlotId(slotId: Int): Flow<List<SlotAndBooking>> {
        return slotDao.getSlotAndBookingWithSlotId(slotId)
    }
}