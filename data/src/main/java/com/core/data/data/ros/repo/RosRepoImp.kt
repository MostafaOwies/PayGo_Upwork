package com.core.data.data.ros.repo

import com.core.data.data.ros.dao.RosDao
import com.core.domain.entities.ROS
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RosRepoImp @Inject constructor(private val rosDao: RosDao) : RosRepo {
    override suspend fun insertROS(ros: ROS) {
        rosDao.insertROS(ros)
    }

    override suspend fun deleteROS(ros: ROS) {
        rosDao.deleteROS(ros)
    }

    override fun getAllRos(): Flow<List<ROS>> {
        return rosDao.getAllRos()
    }
}