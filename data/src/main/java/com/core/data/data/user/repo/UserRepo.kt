package com.core.data.data.user.repo


import com.core.domain.entities.User
import kotlinx.coroutines.flow.Flow

interface UserRepo {

    suspend fun insertUser(user: User)
    suspend fun deleteUser(user: User)
    fun getAllUsers(): Flow<List<User>>
}