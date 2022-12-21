package com.core.data.data.messagenetwork.repo

import com.core.domain.entities.MessageNetwork
import kotlinx.coroutines.flow.Flow

interface MessageNetworkRepo {
    suspend fun insertMessageNetwork(messageNetwork: MessageNetwork)
    suspend fun deleteMessageNetwork(messageNetwork: MessageNetwork)
    fun getAllMessageNetwork(): Flow<List<MessageNetwork>>
}