package com.core.data.database.data.booking

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.core.data.PayGoDatabase
import com.core.data.data.booking.dao.BookingDao
import com.core.domain.entities.Booking
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.text.SimpleDateFormat
import java.util.*

@RunWith(AndroidJUnit4::class)
@SmallTest // test a portion or a class of the app
class BookingDaoTest {

    private lateinit var database: PayGoDatabase
    private lateinit var bookingDao: BookingDao

    @Before // executed before every test case
    fun setUp() {

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PayGoDatabase::class.java
        ).allowMainThreadQueries().build()
        bookingDao = database.getBookingDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertBooking() = runBlocking {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val myDate = dateFormat.format(Date())


        val booking =
            Booking(
                1, 1, 1, 1, createdAt = myDate,
                checkIn = myDate, checkout = myDate, "Mostafa",
                myDate, "MostafaOwies@yahoo.com", "010982626110", 2, "notes"
            )
        bookingDao.insertBooking(booking)

        val allBooking = bookingDao.getAll()

       // assertThat(allBooking).contains(booking)
    }

    @Test
    fun deleteBooking() = runBlocking {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val myDate = dateFormat.format(Date())


        val booking =
            Booking(
                1, 1, 1, 1, createdAt = myDate,
                checkIn = myDate, checkout = myDate, "Mostafa",
                myDate, "MostafaOwies@yahoo.com", "010982626110", 2, "notes"
            )
        bookingDao.insertBooking(booking)
        bookingDao.deleteBooking(booking)

        val allBooking = bookingDao.getAll()

        //assertThat(allBooking).doesNotContain(booking)

    }
}