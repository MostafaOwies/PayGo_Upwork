package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Booking(
    @PrimaryKey
    var bookingId: Int = 0,

    var retailerId: Int = 0,
    var preOrderId: Int = 0,
    var slotId: Int = 0,
    var createdAt: String = "",
    var checkIn: String = "",
    var checkout: String = "",
    var createdBy: String = "",
    var date: String = "",
    var email: String = "",
    var phone: String = "",
    var numberOfGuests: Int = 0,
    var notes: String = "",
    //var preOrderId: Int = 0
)
