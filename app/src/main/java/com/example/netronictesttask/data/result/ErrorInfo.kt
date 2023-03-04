package com.example.netronictesttask.data.result

data class ErrorInfo(
    val code: Int? = null,
    val message: String,
    val customError: CustomError? = null,
    val url: String? = null,
    val exception: Throwable
)