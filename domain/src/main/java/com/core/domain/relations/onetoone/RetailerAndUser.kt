package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Retailer
import com.core.domain.entities.User

data class RetailerAndUser(
    @Embedded val retailer: Retailer,
    @Relation(
        parentColumn = "retailerId",
        entityColumn = "retailerId"
    )
    val user: User
)
