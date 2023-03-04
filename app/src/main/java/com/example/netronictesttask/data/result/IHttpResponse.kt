package com.example.netronictesttask.data.result

interface IHttpResponse {
    val statusCode: Int?
    val statusMessage: String?
    val url: String?
    val errorBody: CustomError?
}