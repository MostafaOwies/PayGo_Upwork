package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RetailerPaymentDetails(
    @PrimaryKey
    var retailerPaymentDetailsId: Int = 0,

    var serviceCharge: Int = 0,
    var discount: Discount,
    var tip: List<Int>,
    var VAT: Int = 0,
)


