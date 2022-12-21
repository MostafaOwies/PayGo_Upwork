package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Discount(


    @PrimaryKey
    var discountId: Int = 0,
    var amount: Int = 0,
)
