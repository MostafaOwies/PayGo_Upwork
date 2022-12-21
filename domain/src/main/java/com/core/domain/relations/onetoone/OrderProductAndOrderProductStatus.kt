package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.OrderProduct
import com.core.domain.entities.OrderProductStatus

data class OrderProductAndOrderProductStatus(
    @Embedded val orderProduct: OrderProduct,
    @Relation(
        parentColumn = "orderProductId",
        entityColumn = "orderProductId"
    )
    val orderProductStatus: OrderProductStatus
)
