package com.example.netronictesttask.domain.mapper

import com.example.netronictesttask.common.util.Utils
import com.example.netronictesttask.data.modeldto.DtoUsersResponse
import com.example.netronictesttask.domain.model.*

class RandomUserMapperImpl: RandomUserMapper {
    override fun usersResponseDtoToDomainList(response: DtoUsersResponse): List<User> {
        val list = response.results.map {
            User(
                UserName(it.name.title, it.name.first, it.name.last),
                UserId(it.id.name, it.id.value ?: Utils.generateRandomString()),
                UserPicture(it.picture.large, it.picture.medium, it.picture.thumbnail),
                it.gender,
                it.email,
                it.phone,
                it.nat
            )
        }.toList()

        return list
    }
}