package com.core.data.data.money.repo


import com.core.domain.entities.Money
import kotlinx.coroutines.flow.Flow

interface MoneyRepo {

    suspend fun insertMoney(money: Money)
    suspend fun deleteMoney(money: Money)
    fun getAllMoney(): Flow<List<Money>>
}