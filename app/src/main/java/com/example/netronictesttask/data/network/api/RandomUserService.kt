package com.example.netronictesttask.data.network.api

import com.example.netronictesttask.data.modeldto.DtoUsersResponse
import com.example.netronictesttask.data.result.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserService {
    @GET("api/")
    suspend fun getUsers(
        @Query("results") resultsCount: Int,
    ): Result<DtoUsersResponse>
}