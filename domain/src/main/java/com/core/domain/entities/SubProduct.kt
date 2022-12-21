package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubProduct(
    @PrimaryKey
    var subProductId: Int = 0,

    var subProductTypeId: Int = 0,
    var name: String = "",
    var logo: String = "",
    var desc: String = "",
    var price: Double = 0.0
)
