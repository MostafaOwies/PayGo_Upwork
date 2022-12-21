package com.core.data.data.messagenetwork.dao

import androidx.room.*
import com.core.domain.entities.MessageNetwork
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageNetworkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessageNetwork(vararg messageNetwork: MessageNetwork)

    @Delete
    suspend fun deleteMessageNetwork(messageNetwork: MessageNetwork)

    @Query("SELECT * FROM `MessageNetwork`")
    fun getAllMessageNetwork(): Flow<List<MessageNetwork>>
}