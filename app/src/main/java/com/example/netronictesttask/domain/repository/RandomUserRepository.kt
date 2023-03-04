package com.example.netronictesttask.domain.repository

import com.example.netronictesttask.data.result.Result
import com.example.netronictesttask.domain.model.User

interface RandomUserRepository {
    suspend fun getUsers(
        count: Int
    ): Result<List<User>>
}