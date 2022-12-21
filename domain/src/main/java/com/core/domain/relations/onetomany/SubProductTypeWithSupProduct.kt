package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.SubProduct
import com.core.domain.entities.SubProductType

data class SubProductTypeWithSupProduct(
    @Embedded val subProductType: SubProductType,
    @Relation(
        parentColumn = "subProductTypeId",
        entityColumn = "subProductTypeId"
    )
    val subProduct: List<SubProduct>
)
