package com.core.data.data.ros.dao

import androidx.room.*
import com.core.domain.entities.ROS
import kotlinx.coroutines.flow.Flow

@Dao
interface RosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertROS(vararg ros: ROS)

    @Delete
    suspend fun deleteROS(ros: ROS)

    @Query("SELECT * FROM ROS")
    fun getAllRos(): Flow<List<ROS>>
}