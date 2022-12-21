package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.core.domain.enums.MoneyISOCode
import com.core.domain.enums.Sectors

@Entity
data class Retailer(
    @PrimaryKey
    var retailerId: Int = 0,

    var addressId: Int = 0,
    var paymentIntegrationId: Int = 0,
    var retailerPaymentDetailsId: Int = 0,
    var sector: Sectors? = null,
    var moneyISOCode: MoneyISOCode? = null,
    var logo: String = "",
    var phone: String = "",
    var createdAt: String = "",
    var updatedAt: String = "",
    var name: String = "",
    var isActive: Boolean = false,
    var startOrderNumber: Int = 0,
    var openTimeFrom: String = "",
    var openTimeTo: String = "",

    )


