package com.core.data.data.slot.dao

import androidx.room.*
import com.core.domain.entities.Slot
import com.core.domain.relations.onetoone.SlotAndBooking
import com.core.domain.relations.onetoone.SlotAndOrder
import kotlinx.coroutines.flow.Flow

@Dao
interface SlotDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSlot(vararg slot: Slot)

    @Delete
    suspend fun deleteSlot(slot: Slot)

    @Query("SELECT * FROM Slot")
    fun getAllSlots(): Flow<List<Slot>>

    @Transaction
    @Query("SELECT * FROM Slot WHERE slotId = :slotId")
    fun getSlotAndOrderWithSlotId(slotId: Int): Flow<List<SlotAndOrder>>

    @Transaction
    @Query("SELECT * FROM Slot WHERE slotId = :slotId")
    fun getSlotAndBookingWithSlotId(slotId: Int): Flow<List<SlotAndBooking>>

}