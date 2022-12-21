package com.core.data.data.user.repo

import com.core.data.data.user.dao.UserDao
import com.core.domain.entities.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepoImp @Inject constructor(private val userDao: UserDao) : UserRepo {
    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }
}