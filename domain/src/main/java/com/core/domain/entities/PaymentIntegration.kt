package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PaymentIntegration(
    @PrimaryKey
    var paymentIntegrationId: Int = 0,

    var type: String = "",
    var cloudRef: String
)
