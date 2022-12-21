package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.PaymentIntegration
import com.core.domain.entities.Retailer

data class PaymentIntegrationAndRetailer(
    @Embedded val paymentIntegration: PaymentIntegration,
    @Relation(
        parentColumn = "paymentIntegrationId",
        entityColumn = "paymentIntegrationId"
    )
    val retailer: Retailer
)
