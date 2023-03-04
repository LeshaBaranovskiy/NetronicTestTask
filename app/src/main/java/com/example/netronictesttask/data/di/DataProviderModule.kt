package com.example.netronictesttask.data.di

import com.example.netronictesttask.data.local.dao.UsersDao
import com.example.netronictesttask.data.local.localdataprovider.LocalUsersDataProvider
import com.example.netronictesttask.data.local.localdataprovider.LocalUsersHelper
import com.example.netronictesttask.data.network.api.RandomUserDataProvider
import com.example.netronictesttask.data.network.api.RandomUserHelper
import com.example.netronictesttask.data.network.api.RandomUserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataProviderModule {

    @Provides
    @Singleton
    fun provideRandomUserDataProvider(
        service: RandomUserService
    ): RandomUserHelper = RandomUserDataProvider(service)

    @Provides
    @Singleton
    fun provideLocalUsersDataProvider(
        usersDao: UsersDao
    ): LocalUsersHelper = LocalUsersDataProvider(usersDao)
}