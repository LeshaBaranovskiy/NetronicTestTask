package com.example.netronictesttask.domain.mapper

import com.example.netronictesttask.data.modeldto.DtoUsersResponse
import com.example.netronictesttask.domain.model.User

interface RandomUserMapper {
    fun usersResponseDtoToDomainList(response: DtoUsersResponse): List<User>
}