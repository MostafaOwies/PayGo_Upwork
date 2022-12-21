package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderStatus(
    @PrimaryKey
    var orderStatusId: Int = 0,

    var isCheckout: Boolean = false,
    var checkoutAt: String = "",
    var isPaid: Boolean = false,
    var paidAt: String = "",
    var isCanceled: Boolean = false,
    var canceledAt: String = "",
    var isRefunded: Boolean = false,
    var refundedAt: String = ""
)
