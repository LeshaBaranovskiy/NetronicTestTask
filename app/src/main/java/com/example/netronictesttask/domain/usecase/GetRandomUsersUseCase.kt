package com.example.netronictesttask.domain.usecase

import com.example.netronictesttask.data.result.Result
import com.example.netronictesttask.domain.model.User
import com.example.netronictesttask.domain.params.RandomUsersParams
import com.example.netronictesttask.domain.repository.RandomUserRepository

class GetRandomUsersUseCase(
    private val repository: RandomUserRepository
): BaseUseCase<RandomUsersParams, List<User>>() {

    override suspend fun getSuspend(params: RandomUsersParams): Result<List<User>> {
        return repository.getUsers(params.count)
    }
}