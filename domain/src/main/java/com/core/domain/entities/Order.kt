package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.core.domain.enums.ServingMethod

@Entity
data class Order(
    @PrimaryKey
    var orderId: Int = 0,

    var retailerId: Int = 0,
    var orderFinanceId: Int = 0,
    var orderStatusId: Int = 0,
    var slotId: Int = 0,
    var createdAt: String = "",
    var rosTypes: List<String>? = null,
    var paidBy: String = "",
    var createdBy: String = "",
    var isOMA: Boolean = false,
    var orderNumber: Int = 0,
    var servingMethod: ServingMethod? = null,
    var tagName: String = "",
    var isOnlineOrder: Boolean = false,
)


