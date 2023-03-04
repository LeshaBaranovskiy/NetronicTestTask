package com.example.netronictesttask.data.network.source

import com.example.netronictesttask.data.result.ErrorIdentifier
import com.example.netronictesttask.data.result.ResultAdapterFactory
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val gson: Gson,
    private val errorIdentifier: ErrorIdentifier
): RemoteDataSourceHelper {

    override fun <Api> buildApi(
        api: Class<Api>,
        url: String,
        isCache: Boolean,
    ): Api {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(ResultAdapterFactory(errorIdentifier))
            .build()
            .create(api)
    }
}