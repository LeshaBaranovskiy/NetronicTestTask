package com.example.netronictesttask.domain.usecase

import com.example.netronictesttask.data.local.entity.DbUserEntity
import com.example.netronictesttask.domain.repository.LocalUsersRepository

class DbGetUserByIdUseCase(
    private val localUsersRepository: LocalUsersRepository
): BaseDbUseCase<String, DbUserEntity>() {
    override suspend fun getSuspend(params: String): DbUserEntity {
        return localUsersRepository.getUserById(params)
    }
}