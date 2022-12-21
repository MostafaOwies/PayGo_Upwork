package com.core.data.data.messagenetwork.repo

import com.core.data.data.messagenetwork.dao.MessageNetworkDao
import com.core.domain.entities.MessageNetwork
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MessageNetworkRepoImp @Inject constructor(private val messageNetworkDao: MessageNetworkDao) :
    MessageNetworkRepo {

    override suspend fun insertMessageNetwork(messageNetwork: MessageNetwork) {
        messageNetworkDao.insertMessageNetwork(messageNetwork)
    }

    override suspend fun deleteMessageNetwork(messageNetwork: MessageNetwork) {
        messageNetworkDao.deleteMessageNetwork(messageNetwork)
    }

    override fun getAllMessageNetwork(): Flow<List<MessageNetwork>> {
        return messageNetworkDao.getAllMessageNetwork()
    }

}