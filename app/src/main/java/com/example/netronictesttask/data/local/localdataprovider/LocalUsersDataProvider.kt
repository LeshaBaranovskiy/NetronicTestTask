package com.example.netronictesttask.data.local.localdataprovider

import com.example.netronictesttask.data.local.dao.UsersDao
import com.example.netronictesttask.data.local.entity.DbUserEntity
import javax.inject.Inject

class LocalUsersDataProvider @Inject constructor(
    private val usersDao: UsersDao
): LocalUsersHelper {
    override suspend fun getAllUsers(): List<DbUserEntity> =
        usersDao.getAllUsers()

    override suspend fun getUserById(id: String): DbUserEntity =
        usersDao.getUserById(id)

    override suspend fun deleteAllFromUsers() =
        usersDao.deleteAllFromUsers()

    override suspend fun insertUsers(insertUsers: List<DbUserEntity>) =
        usersDao.insertUsers(insertUsers)
}