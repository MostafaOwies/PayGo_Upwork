package com.core.data.data.booking.di

import com.core.data.PayGoDatabase
import com.core.data.data.booking.dao.BookingDao
import com.core.data.data.booking.repo.BookingRepo
import com.core.data.data.booking.repo.BookingRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BookingModule {

    @Provides
    @Singleton
    fun provideBookingDao(db: PayGoDatabase): BookingDao {
        return db.getBookingDao()
    }

    @Provides
    @Singleton
    fun provideBookingRepo(bookingRepoImp: BookingRepoImp): BookingRepo {
        return bookingRepoImp
    }
}