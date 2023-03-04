package com.example.netronictesttask.domain.repository

import com.example.netronictesttask.data.local.entity.DbUserEntity
import com.example.netronictesttask.data.local.localdataprovider.LocalUsersHelper
import com.example.netronictesttask.domain.mapper.LocalUsersMapper
import com.example.netronictesttask.domain.model.User
import javax.inject.Inject

class LocalUsersRepositoryImpl @Inject constructor(
    private val localUsersHelper: LocalUsersHelper,
    private val localUsersMapper: LocalUsersMapper
): LocalUsersRepository {
    override suspend fun getAllUsers(): List<User> {
        return localUsersHelper.getAllUsers().map {
            localUsersMapper.mapDbEntityUserToDomainUser(it)
        }
    }

    override suspend fun getUserById(id: String): DbUserEntity =
        localUsersHelper.getUserById(id)

    override suspend fun deleteAllFromUsers() =
        localUsersHelper.deleteAllFromUsers()

    override suspend fun insertUsers(insertUsers: List<User>) {
        localUsersHelper.insertUsers(
            insertUsers.map {
                localUsersMapper.mapDomainUserToDbEntity(it)
            }.toList()
        )
    }

}