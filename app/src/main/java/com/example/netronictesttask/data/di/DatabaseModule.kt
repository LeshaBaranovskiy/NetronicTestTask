package com.example.netronictesttask.data.di

import android.app.Application
import android.content.Context
import com.example.netronictesttask.data.local.AppDatabase
import com.example.netronictesttask.data.local.dao.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideUsersDao(appDatabase: AppDatabase): UsersDao =
        appDatabase.getUsersDao()

    @Singleton
    @Provides
    fun provideDBInstance(context: Context): AppDatabase =
        AppDatabase.getAppDataBase(context)

    @Singleton
    @Provides
    fun provideAppContext(application: Application): Context =
        application.applicationContext
}