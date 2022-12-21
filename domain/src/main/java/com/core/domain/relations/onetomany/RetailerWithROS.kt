package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.ROS
import com.core.domain.entities.Retailer

data class RetailerWithROS(
    @Embedded val retailer: Retailer,
    @Relation(
        parentColumn = "retailerId",
        entityColumn = "retailerId"
    )
    val ros: List<ROS>
)
