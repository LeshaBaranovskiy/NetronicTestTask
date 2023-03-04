package com.example.netronictesttask.domain.repository

import com.example.netronictesttask.data.local.entity.DbUserEntity
import com.example.netronictesttask.domain.model.User

interface LocalUsersRepository {
    suspend fun getAllUsers(): List<User>

    suspend fun getUserById(id: String): DbUserEntity

    suspend fun deleteAllFromUsers()

    suspend fun insertUsers(insertUsers: List<User>)
}