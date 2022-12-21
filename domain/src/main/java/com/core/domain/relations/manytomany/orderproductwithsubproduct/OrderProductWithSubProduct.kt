package com.core.domain.relations.manytomany.orderproductwithsubproduct

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.core.domain.entities.OrderProduct
import com.core.domain.entities.SubProduct

data class OrderProductWithSubProduct(
    @Embedded val orderProduct: OrderProduct,
    @Relation(
        parentColumn = "orderProductId",
        entityColumn = "subProductId",
        associateBy = Junction(OrderProductWithSubProductCrossRef::class)
    )
    val subProduct: List<SubProduct>
)
