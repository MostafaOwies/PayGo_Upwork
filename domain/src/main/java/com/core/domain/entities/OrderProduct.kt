package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderProduct(
    @PrimaryKey(autoGenerate = true)
    var orderProductId: Int = 0,

    var orderId: Int = 0,
    var ProductId: Int = 0,
    var name: String = "",
    var qty: Int = 0,
    var price: Double = 0.0,
    var stringPrice: String = price.toString(),
    var total: Double = 0.0,
    var notes: String = ""
)
