package com.example.netronictesttask.data.network.api

import com.example.netronictesttask.data.modeldto.DtoUsersResponse
import com.example.netronictesttask.data.result.Result
import retrofit2.Call
import javax.inject.Inject

class RandomUserDataProvider @Inject constructor(
    private val service: RandomUserService
): RandomUserHelper {

    override suspend fun getUsers(resultsCount: Int): Result<DtoUsersResponse> =
        service.getUsers(resultsCount)
}