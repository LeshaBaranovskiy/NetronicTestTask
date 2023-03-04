package com.example.netronictesttask.data.modeldto

import com.google.gson.annotations.SerializedName

data class DtoUsersResponse(
    @SerializedName("results")
    val results: List<DtoUser>
)