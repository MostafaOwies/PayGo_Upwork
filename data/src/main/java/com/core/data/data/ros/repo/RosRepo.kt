package com.core.data.data.ros.repo


import com.core.domain.entities.ROS
import kotlinx.coroutines.flow.Flow

interface RosRepo {

    suspend fun insertROS(ros: ROS)
    suspend fun deleteROS(ros: ROS)
    fun getAllRos(): Flow<List<ROS>>
}