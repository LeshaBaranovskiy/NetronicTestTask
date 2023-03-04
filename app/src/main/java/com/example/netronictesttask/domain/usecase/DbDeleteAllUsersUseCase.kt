package com.example.netronictesttask.domain.usecase

import com.example.netronictesttask.domain.repository.LocalUsersRepository

class DbDeleteAllUsersUseCase(
    private val localUsersRepository: LocalUsersRepository
): BaseDbUseCase<Unit, Unit>() {
    override suspend fun getSuspend(params: Unit): Unit {
        return localUsersRepository.deleteAllFromUsers()
    }
}