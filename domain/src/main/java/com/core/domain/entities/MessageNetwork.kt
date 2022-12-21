package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MessageNetwork(

    @PrimaryKey
    var messageNetworkId: Int = 0,

    var actionId: Int = 0,
    var received: Boolean = false,
    var count: Int = 0,
    var source: String = "",
    var destination: String,
)
