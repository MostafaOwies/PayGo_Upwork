package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey
    var ProductId: Int = 0,

    var categoryId: Int = 0,
    var discountId: Int = 0,
    var name: String = "",
    var qty: Int = 0,
    var logo: String = "",
    var desc: String = "",
    var price: Double = 0.0,
    var stringPrice: String = price.toString(),
    var isFavorite: Boolean = false,

    )
