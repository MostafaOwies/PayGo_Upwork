package com.core.data.data.booking.dao

import androidx.room.*
import com.core.domain.entities.Booking
import kotlinx.coroutines.flow.Flow

@Dao
interface BookingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooking(vararg booking: Booking)

    @Delete
    suspend fun deleteBooking(booking: Booking)

    @Query("SELECT * FROM Booking")
    fun getAll(): Flow<List<Booking>>
}