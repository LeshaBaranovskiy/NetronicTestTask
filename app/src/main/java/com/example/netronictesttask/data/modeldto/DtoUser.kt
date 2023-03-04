package com.example.netronictesttask.data.modeldto

import com.google.gson.annotations.SerializedName

data class DtoUser(
    @SerializedName("name")
    val name: DtoUserName,
    @SerializedName("id")
    val id: DtoUserId,
    @SerializedName("picture")
    val picture: DtoUserPicture,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("nat")
    val nat: String
)

data class DtoUserId(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String?
)

data class DtoUserPicture(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)

data class DtoUserName(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)