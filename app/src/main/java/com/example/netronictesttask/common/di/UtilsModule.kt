package com.example.netronictesttask.common.di

import android.app.Application
import android.content.SharedPreferences
import com.example.netronictesttask.common.util.PrefsHelper
import com.example.netronictesttask.data.result.ErrorIdentifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UtilsModule {
    @Provides
    @Singleton
    fun provideErrorIdentifier(): ErrorIdentifier =
        ErrorIdentifier()

    @Provides
    @Singleton
    fun provideDarkModePreferences(application: Application): PrefsHelper {
        return PrefsHelper(application.applicationContext)
    }
}