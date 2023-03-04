package com.example.netronictesttask.data.di

import com.example.netronictesttask.common.util.Constants
import com.example.netronictesttask.data.network.api.RandomUserService
import com.example.netronictesttask.data.network.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideRandomUsersService(remoteDataSource: RemoteDataSource): RandomUserService =
        remoteDataSource.buildApi(
            RandomUserService::class.java,
            Constants.API_SERVICE_URL
        )
}