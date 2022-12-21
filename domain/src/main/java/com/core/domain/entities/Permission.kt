package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Permission(
    @PrimaryKey
    var permissionId: Int = 0,

    var userId: Int = 0,
    var canEditOrder: Boolean = false,
    var canCreateOrder: Boolean = false,
    var canSplitOrder: Boolean = false,
    var canShareItem: Boolean = false,


    )
