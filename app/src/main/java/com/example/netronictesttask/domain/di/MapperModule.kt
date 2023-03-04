package com.example.netronictesttask.domain.di

import com.example.netronictesttask.domain.mapper.LocalUsersMapper
import com.example.netronictesttask.domain.mapper.LocalUsersMapperImpl
import com.example.netronictesttask.domain.mapper.RandomUserMapper
import com.example.netronictesttask.domain.mapper.RandomUserMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MapperModule {
    @Provides
    @Singleton
    fun provideRandomUserMapper(): RandomUserMapper =
        RandomUserMapperImpl()

    @Provides
    @Singleton
    fun provideLocalUsersMapperImpl(): LocalUsersMapper =
        LocalUsersMapperImpl()
}