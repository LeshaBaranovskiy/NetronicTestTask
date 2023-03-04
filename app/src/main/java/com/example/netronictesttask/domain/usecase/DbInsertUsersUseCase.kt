package com.example.netronictesttask.domain.usecase

import com.example.netronictesttask.data.local.entity.DbUserEntity
import com.example.netronictesttask.data.result.Result
import com.example.netronictesttask.domain.model.User
import com.example.netronictesttask.domain.repository.LocalUsersRepository

class DbInsertUsersUseCase(
    private val localUsersRepository: LocalUsersRepository
): BaseDbUseCase<List<User>, Unit>() {
    override suspend fun getSuspend(params: List<User>): Unit {
        return localUsersRepository.insertUsers(params)
    }
}