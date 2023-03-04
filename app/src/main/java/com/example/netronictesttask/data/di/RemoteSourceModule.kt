package com.example.netronictesttask.data.di

import com.example.netronictesttask.data.network.source.RemoteDataSource
import com.example.netronictesttask.data.network.source.RemoteDataSourceHelper
import com.example.netronictesttask.data.result.ErrorIdentifier
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(
        gson: Gson,
        errorIdentifier: ErrorIdentifier
    ): RemoteDataSourceHelper =
        RemoteDataSource(
            gson,
            errorIdentifier
        )

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()
}