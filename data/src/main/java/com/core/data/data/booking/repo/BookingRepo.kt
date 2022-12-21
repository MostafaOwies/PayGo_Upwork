package com.core.data.data.booking.repo

import com.core.domain.entities.Booking
import kotlinx.coroutines.flow.Flow

interface BookingRepo {
    suspend fun insertBooking(booking: Booking)
    suspend fun deleteBooking(booking: Booking)
    fun getAllBookings(): Flow<List<Booking>>
}