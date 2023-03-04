package com.example.netronictesttask.domain.mapper

import com.example.netronictesttask.data.local.entity.DbUserEntity
import com.example.netronictesttask.domain.model.User
import com.example.netronictesttask.domain.model.UserId
import com.example.netronictesttask.domain.model.UserName
import com.example.netronictesttask.domain.model.UserPicture

class LocalUsersMapperImpl: LocalUsersMapper {
    override fun mapDomainUserToDbEntity(user: User): DbUserEntity =
        DbUserEntity(
            userId = user.id.value,
            name = user.name.title + " " + user.name.first + " " + user.name.last,
            email = user.email,
            phone = user.phone,
            gender = user.gender,
            nationality = user.nat,
            imageName = user.id.value + ".jpg"
        )

    override fun mapDbEntityUserToDomainUser(user: DbUserEntity): User =
        User(
            name = UserName(user.name.split(" ")[0], user.name.split(" ")[1], user.name.split(" ")[2]),
            id = UserId(name = "", value = user.userId),
            picture = UserPicture(large = user.imageName, medium = "", thumbnail = ""),
            gender = user.gender,
            email = user.email,
            phone = user.phone,
            nat = user.nationality
        )
}