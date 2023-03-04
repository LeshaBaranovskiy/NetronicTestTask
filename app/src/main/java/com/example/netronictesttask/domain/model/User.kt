package com.example.netronictesttask.domain.model

data class User(
    val name: UserName,
    val id: UserId,
    val picture: UserPicture,
    val gender: String,
    val email: String,
    val phone: String,
    val nat: String
)

data class UserId(
    val name: String,
    val value: String
)

data class UserPicture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class UserName(
    val title: String,
    val first: String,
    val last: String
)
