package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ROS(
    @PrimaryKey
    var rosId: Int = 0,

    var retailerId: Int = 0,
    var type: String = "",
    var number: Int,
    var isActive: Boolean = false
)
