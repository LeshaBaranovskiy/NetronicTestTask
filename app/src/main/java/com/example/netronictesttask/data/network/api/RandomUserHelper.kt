package com.example.netronictesttask.data.network.api

import com.example.netronictesttask.data.modeldto.DtoUsersResponse
import com.example.netronictesttask.data.result.Result
import retrofit2.Call

interface RandomUserHelper {
    suspend fun getUsers(resultsCount: Int): Result<DtoUsersResponse>
}