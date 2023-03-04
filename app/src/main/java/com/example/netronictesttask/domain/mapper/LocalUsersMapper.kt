package com.example.netronictesttask.domain.mapper

import com.example.netronictesttask.data.local.entity.DbUserEntity
import com.example.netronictesttask.domain.model.User

interface LocalUsersMapper {
    fun mapDomainUserToDbEntity(user: User): DbUserEntity

    fun mapDbEntityUserToDomainUser(user: DbUserEntity): User
}