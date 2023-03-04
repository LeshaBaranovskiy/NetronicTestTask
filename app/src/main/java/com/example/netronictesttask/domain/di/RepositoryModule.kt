package com.example.netronictesttask.domain.di

import com.example.netronictesttask.data.local.localdataprovider.LocalUsersHelper
import com.example.netronictesttask.data.network.api.RandomUserHelper
import com.example.netronictesttask.domain.mapper.LocalUsersMapper
import com.example.netronictesttask.domain.mapper.RandomUserMapper
import com.example.netronictesttask.domain.repository.LocalUsersRepository
import com.example.netronictesttask.domain.repository.LocalUsersRepositoryImpl
import com.example.netronictesttask.domain.repository.RandomUserRepository
import com.example.netronictesttask.domain.repository.RandomUserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRandomUserRepository(
        randomUserHelper: RandomUserHelper,
        randomUserMapper: RandomUserMapper
    ): RandomUserRepository =
        RandomUserRepositoryImpl(randomUserHelper, randomUserMapper)

    @Provides
    @Singleton
    fun provideLocalUsersRepository(
        localUsersHelper: LocalUsersHelper,
        localUsersMapper: LocalUsersMapper
    ): LocalUsersRepository =
        LocalUsersRepositoryImpl(localUsersHelper, localUsersMapper)
}