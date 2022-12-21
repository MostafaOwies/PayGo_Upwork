package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.core.domain.enums.ServingMethod

@Entity
data class Offer(

    @PrimaryKey
    var offerId: Int = 0,

    var available: Boolean = false,
    var desc: String = "",
    var discountPercent: Int = 0,
    var timeFrom: Int = 0,
    var timeTo: Int = 0,
    var logo: String = "",
    var dateFrom: Int = 0,
    var dateTo: Int = 0,
    var servingMethod: ServingMethod? = null,
    var weekDays: List<Int?>? = null,
    var fixedPrice: Double = 0.0

)
