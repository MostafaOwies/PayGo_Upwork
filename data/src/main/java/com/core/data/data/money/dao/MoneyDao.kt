package com.core.data.data.money.dao

import androidx.room.*
import com.core.domain.entities.Money
import kotlinx.coroutines.flow.Flow

@Dao
interface MoneyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoney(vararg money: Money)

    @Delete
    suspend fun deleteMoney(money: Money)

    @Query("SELECT * FROM Money")
    fun getAllMoney(): Flow<List<Money>>
}