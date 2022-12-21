package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderProductStatus(
    @PrimaryKey
    var orderProductStatusId: Int = 0,

    var orderProductId: Int = 0,
    var placed: String = "",
    var preparing: String = "",
    var completed: String = "",
    var delivered: String = ""
)
