package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Order
import com.core.domain.entities.OrderFinance

data class OrderFinanceAndOrder(
    @Embedded val orderFinance: OrderFinance,
    @Relation(
        parentColumn = "orderFinanceId",
        entityColumn = "orderFinanceId"
    )
    val order: Order
)