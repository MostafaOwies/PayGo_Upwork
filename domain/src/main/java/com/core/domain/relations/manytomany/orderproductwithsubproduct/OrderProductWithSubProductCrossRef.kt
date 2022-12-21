package com.core.domain.relations.manytomany.orderproductwithsubproduct

import androidx.room.Entity

@Entity(primaryKeys = ["orderProductId", "subProductId"])
data class OrderProductWithSubProductCrossRef(
    var orderProductId: Int = 0,
    var subProductId: Int = 0
)
