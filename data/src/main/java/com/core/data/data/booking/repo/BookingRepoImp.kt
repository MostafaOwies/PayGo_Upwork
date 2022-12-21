package com.core.data.data.booking.repo

import com.core.data.data.booking.dao.BookingDao
import com.core.domain.entities.Booking
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class BookingRepoImp @Inject constructor(private val bookingDao: BookingDao) : BookingRepo {

    override suspend fun insertBooking(booking: Booking) {
        bookingDao.insertBooking(booking)
    }

    override suspend fun deleteBooking(booking: Booking) {
        bookingDao.deleteBooking(booking)
    }

    override fun getAllBookings(): Flow<List<Booking>> = bookingDao.getAll()
}