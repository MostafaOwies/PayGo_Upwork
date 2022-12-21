package com.core.domain.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.core.domain.entities.Action
import com.core.domain.entities.MessageNetwork

data class ActionAndMessageNetwork(
    @Embedded val action: Action,
    @Relation(
        parentColumn = "actionId",
        entityColumn = "actionId"
    )
    val messageNetwork: MessageNetwork

)
