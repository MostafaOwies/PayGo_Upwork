package com.core.data.data.permission.dao

import androidx.room.*
import com.core.domain.entities.Permission
import kotlinx.coroutines.flow.Flow

@Dao
interface PermissionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPermission(vararg permission: Permission)

    @Delete
    suspend fun deletePermission(permission: Permission)

    @Query("SELECT * FROM Permission")
    fun getAllPermissions(): Flow<List<Permission>>
}