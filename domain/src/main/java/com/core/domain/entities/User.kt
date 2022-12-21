package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    var userId: Int = 0,

    var retailerId: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var role: String = "",
    var phone: String = "",
    var createdAt: String = "",
    var updatedAt: String = "",

    )
