package com.example.netronictesttask.domain.repository

import com.example.netronictesttask.data.network.api.RandomUserHelper
import com.example.netronictesttask.data.result.Result
import com.example.netronictesttask.data.result.map
import com.example.netronictesttask.domain.mapper.RandomUserMapper
import com.example.netronictesttask.domain.model.User
import javax.inject.Inject

class RandomUserRepositoryImpl @Inject constructor(
    private val randomUserHelper: RandomUserHelper,
    private val mapper: RandomUserMapper
) : RandomUserRepository {

    override suspend fun getUsers(count: Int): Result<List<User>> {
        return randomUserHelper.getUsers(count).map {
            mapper.usersResponseDtoToDomainList(it)
        }
    }
}