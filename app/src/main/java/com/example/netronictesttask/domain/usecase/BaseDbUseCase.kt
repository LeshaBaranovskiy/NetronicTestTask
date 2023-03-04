package com.example.netronictesttask.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.netronictesttask.data.result.Result
import kotlinx.coroutines.Dispatchers

abstract class BaseDbUseCase<Params, Type> {
    fun getExecute(
        params: Params,
    ): LiveData<Type> {
        return liveData(Dispatchers.IO) {
            try {
                emit(getSuspend(params))
            } catch (exception: Exception) {
                Log.d("EXECUTION_ERROR", exception.message.toString())
            }
        }
    }

    abstract suspend fun getSuspend(params: Params): Type
}