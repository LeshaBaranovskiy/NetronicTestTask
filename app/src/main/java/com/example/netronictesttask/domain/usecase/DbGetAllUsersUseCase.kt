package com.example.netronictesttask.domain.usecase

import com.example.netronictesttask.domain.model.User
import com.example.netronictesttask.domain.repository.LocalUsersRepository

class DbGetAllUsersUseCase(
    private val localUsersRepository: LocalUsersRepository
): BaseDbUseCase<Unit, List<User>>() {
    override suspend fun getSuspend(params: Unit): List<User> {
        return localUsersRepository.getAllUsers()
    }
}