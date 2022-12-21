package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Action(

    @PrimaryKey(autoGenerate = false)
    var actionId: Int = 0,

    var event: String = "",
    var destination: String = ""
)
