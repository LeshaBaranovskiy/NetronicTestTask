package com.example.netronictesttask.data.local.localdataprovider

import com.example.netronictesttask.data.local.entity.DbUserEntity

interface LocalUsersHelper {
    suspend fun getAllUsers(): List<DbUserEntity>

    suspend fun getUserById(id: String): DbUserEntity

    suspend fun deleteAllFromUsers()

    suspend fun insertUsers(insertUsers: List<DbUserEntity>)
}