package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.category.Category
import com.core.domain.entities.Retailer

data class RetailerWithCategory(
    @Embedded val retailer: Retailer,
    @Relation(
        parentColumn = "retailerId",
        entityColumn = "retailerId"
    )
    val categories: List<Category>
)