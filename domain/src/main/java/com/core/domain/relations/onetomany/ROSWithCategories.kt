package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.category.Category
import com.core.domain.entities.ROS

data class ROSWithCategories(
    @Embedded val ros: ROS,
    @Relation(
        parentColumn = "rosId",
        entityColumn = "rosId"
    )
    val categories: List<Category>
)
