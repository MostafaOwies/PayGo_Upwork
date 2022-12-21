package com.core.data.data.permission.repo


import com.core.domain.entities.Permission
import kotlinx.coroutines.flow.Flow

interface PermissionRepo {

    suspend fun insertPermission(permission: Permission)
    suspend fun deletePermission(permission: Permission)
    fun getAllPermissions(): Flow<List<Permission>>
}