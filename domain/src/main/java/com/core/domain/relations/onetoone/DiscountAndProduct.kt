package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Discount
import com.core.domain.entities.Product

data class DiscountAndProduct(
    @Embedded val discount: Discount,
    @Relation(
        parentColumn = "discountId",
        entityColumn = "discountId"
    )
    val product: Product
)
