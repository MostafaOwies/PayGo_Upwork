package com.core.data.data.money.repo

import com.core.data.data.money.dao.MoneyDao
import com.core.domain.entities.Money
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoneyRepoImp @Inject constructor(private val moneyDao: MoneyDao) : MoneyRepo {

    override suspend fun insertMoney(money: Money) {
        moneyDao.insertMoney(money)
    }

    override suspend fun deleteMoney(money: Money) {
        moneyDao.deleteMoney(money)
    }

    override fun getAllMoney(): Flow<List<Money>> {
        return moneyDao.getAllMoney()
    }
}