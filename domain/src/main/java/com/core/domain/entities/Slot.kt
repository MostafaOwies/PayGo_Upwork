package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.core.domain.enums.SlotTypes

@Entity
data class Slot(
    @PrimaryKey
    var slotId: Int = 0,

    var retailerId: Int = 0,
    var tag: Int = 0,
    var reserveOnlineAvailability: Boolean = false,
    var desc: String = "",
    var capacity: Int = 0,
    var type: SlotTypes
)

