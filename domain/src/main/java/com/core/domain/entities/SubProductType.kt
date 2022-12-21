package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubProductType(

    @PrimaryKey
    var subProductTypeId: Int = 0,

    var ProductId: Int = 0,
    var name: String = "",
    var logo: String = "",
    var desc: String = "",
    var min: Int = 0,
    var max: Int = 0
)
