package com.example.netronictesttask.domain.di

import com.example.netronictesttask.domain.repository.LocalUsersRepository
import com.example.netronictesttask.domain.repository.RandomUserRepository
import com.example.netronictesttask.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetRandomUsersUseCase(repository: RandomUserRepository): GetRandomUsersUseCase =
        GetRandomUsersUseCase(repository)

    @Provides
    @Singleton
    fun provideDbInsertUsersUseCase(repository: LocalUsersRepository): DbInsertUsersUseCase =
        DbInsertUsersUseCase(repository)

    @Provides
    @Singleton
    fun provideDbDeleteAllUsersUseCase(repository: LocalUsersRepository): DbDeleteAllUsersUseCase =
        DbDeleteAllUsersUseCase(repository)

    @Provides
    @Singleton
    fun provideDbGetUserByIdUseCase(repository: LocalUsersRepository): DbGetUserByIdUseCase =
        DbGetUserByIdUseCase(repository)

    @Provides
    @Singleton
    fun provideDbGetAllUsersUseCase(repository: LocalUsersRepository): DbGetAllUsersUseCase =
        DbGetAllUsersUseCase(repository)
}