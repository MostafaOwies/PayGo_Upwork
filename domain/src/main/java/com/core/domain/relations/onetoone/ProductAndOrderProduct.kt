package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.OrderProduct
import com.core.domain.entities.Product

data class ProductAndOrderProduct(
    @Embedded val product: Product,
    @Relation(
        parentColumn = "ProductId",
        entityColumn = "ProductId"
    )
    val orderProduct: OrderProduct
)
