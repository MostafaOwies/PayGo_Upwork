package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Product
import com.core.domain.entities.SubProductType

data class ProductWithSubProductType(
    @Embedded val product: Product,
    @Relation(
        parentColumn = "ProductId",
        entityColumn = "ProductId"
    )
    val subProductType: List<SubProductType>
)
