package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.core.domain.enums.CardIntegrationType

@Entity
data class OrderFinance(

    @PrimaryKey
    var orderFinanceId: Int = 0,


    var subTotal: Double = 0.0,
    var totalDiscount: Double = 0.0,
    var total: Double = 0.0,
    var VAT: Double = 0.0,
    var serviceCharge: Double = 0.0,
    var tip: Double = 0.0,
    var netAmount: Double = 0.0,
    var refund: Double = 0.0,
    var onlineRequestId: String = "",
    var cardRequestId: String = "",
    var cardIntegrationType: CardIntegrationType
)
