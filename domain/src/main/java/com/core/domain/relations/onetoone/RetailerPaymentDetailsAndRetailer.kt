package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Retailer
import com.core.domain.entities.RetailerPaymentDetails

data class RetailerPaymentDetailsAndRetailer(
    @Embedded val retailerPaymentDetails: RetailerPaymentDetails,
    @Relation(
        parentColumn = "retailerPaymentDetailsId",
        entityColumn = "retailerPaymentDetailsId"
    )
    val retailer: Retailer
)
