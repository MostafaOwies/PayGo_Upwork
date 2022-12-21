package com.core.domain.relations.manytomany.orderproductwithsubproduct

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.core.domain.entities.OrderProduct
import com.core.domain.entities.SubProduct

data class SubProductWithOrderProduct(
    @Embedded val subProduct: SubProduct,
    @Relation(
        parentColumn = "subProductId",
        entityColumn = "orderProductId",
        associateBy = Junction(OrderProductWithSubProductCrossRef::class)
    )
    val orderProduct: List<OrderProduct>
)
