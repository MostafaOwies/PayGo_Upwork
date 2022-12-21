package com.core.data.data.action.repo

import com.core.domain.entities.Action
import com.core.domain.relations.onetoone.ActionAndMessageNetwork
import kotlinx.coroutines.flow.Flow

interface ActionRepo {

    suspend fun insertAction(action: Action)
    suspend fun deleteAction(action: Action)
    fun getAllActions(): Flow<List<Action>>
    fun getActionAndMessageNetworkWithActionId(actionId: Int): Flow<List<ActionAndMessageNetwork>>
}