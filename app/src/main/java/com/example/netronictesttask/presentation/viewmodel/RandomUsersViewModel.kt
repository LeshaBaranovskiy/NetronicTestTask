package com.example.netronictesttask.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.netronictesttask.data.local.entity.DbUserEntity
import com.example.netronictesttask.data.result.Result
import com.example.netronictesttask.domain.model.User
import com.example.netronictesttask.domain.params.RandomUsersParams
import com.example.netronictesttask.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RandomUsersViewModel @Inject constructor(
    private val getRandomUsersUseCase: GetRandomUsersUseCase,
    private val getAllUsersUseCase: DbGetAllUsersUseCase,
    private val getUserByIdUseCase: DbGetUserByIdUseCase,
    private val insertUsersUseCase: DbInsertUsersUseCase,
    private val deleteAllUsersUseCase: DbDeleteAllUsersUseCase
): ViewModel() {

    fun getUsers(params: RandomUsersParams): LiveData<Result<List<User>>> {
        return getRandomUsersUseCase.getExecute(params)
    }

    fun getAllUsersFromDb(): LiveData<List<User>> {
        return getAllUsersUseCase.getExecute(Unit)
    }

    fun getUserFromDb(userId: String): LiveData<DbUserEntity> {
        return getUserByIdUseCase.getExecute(userId)
    }

    fun insertUsersToDb(users: List<User>): LiveData<Unit> {
        return insertUsersUseCase.getExecute(users)
    }

    fun deleteAllUsersFromDb(): LiveData<Unit> {
        return deleteAllUsersUseCase.getExecute(Unit)
    }
}