package com.core.data.data.action.repo

import com.core.data.data.action.dao.ActionDao
import com.core.domain.entities.Action
import com.core.domain.relations.onetoone.ActionAndMessageNetwork
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ActionRepoImp @Inject constructor(private val actionDao: ActionDao) : ActionRepo {

    override suspend fun insertAction(action: Action) {
        actionDao.insertAction(action)
    }

    override suspend fun deleteAction(action: Action) {
        actionDao.deleteAction(action)
    }

    override fun getAllActions(): Flow<List<Action>> = actionDao.getAllActions()

    override fun getActionAndMessageNetworkWithActionId(actionId: Int): Flow<List<ActionAndMessageNetwork>> =
        actionDao.getActionAndMessageNetworkWithActionId(actionId)
}