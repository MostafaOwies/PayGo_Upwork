package com.core.data.data.action.dao

import androidx.room.*
import com.core.domain.entities.Action
import com.core.domain.relations.onetoone.ActionAndMessageNetwork
import kotlinx.coroutines.flow.Flow

@Dao
interface ActionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAction(vararg action: Action)

    @Delete
    suspend fun deleteAction(action: Action)

    @Query("SELECT * FROM `Action`")
    fun getAllActions(): Flow<List<Action>>

    @Transaction
    @Query("SELECT * FROM `Action` WHERE actionId = :actionId")
    fun getActionAndMessageNetworkWithActionId(actionId: Int): Flow<List<ActionAndMessageNetwork>>
}