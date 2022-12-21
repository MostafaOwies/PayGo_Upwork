package com.core.domain.relations.onetomany

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Address
import com.core.domain.entities.Retailer

data class AddressWithRetailer(
    @Embedded val address: Address,
    @Relation(
        parentColumn = "addressId",
        entityColumn = "addressId"
    )
    val retailers: List<Retailer>
)
