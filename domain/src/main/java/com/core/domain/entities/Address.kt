package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Address(
    @PrimaryKey
    var addressId: Int = 0,

    var city: String = "",
    var street: String = "",
    var postCode: String = "",
    var building: String = "",
    var createdAt: String = "",
    var updatedAt: String = "",
    var latitude: Double = 0.0,
    var longitude: Double = 0.0,
    var country: String = "",
    var state: String = ""
)
