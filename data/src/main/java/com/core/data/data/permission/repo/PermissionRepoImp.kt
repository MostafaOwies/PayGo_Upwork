package com.core.data.data.permission.repo

import com.core.data.data.permission.dao.PermissionDao
import com.core.domain.entities.Permission
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PermissionRepoImp @Inject constructor(private val permissionDao: PermissionDao) :
    PermissionRepo {

    override suspend fun insertPermission(permission: Permission) {
        permissionDao.insertPermission(permission)
    }

    override suspend fun deletePermission(permission: Permission) {
        permissionDao.deletePermission(permission)
    }

    override fun getAllPermissions(): Flow<List<Permission>> {
        return permissionDao.getAllPermissions()
    }
}