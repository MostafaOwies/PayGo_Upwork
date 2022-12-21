package com.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.core.domain.enums.MoneyISOCode

@Entity
data class Money(
    @PrimaryKey
    var moneyId: Int,
    var amount: Int,
    var isoCode: MoneyISOCode
)


