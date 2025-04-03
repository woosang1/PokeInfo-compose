package com.example.network

sealed class ApiResult<out T> {
    data class Success<out T>(val value: T): ApiResult<T>()
    data class Error(val exception: Throwable): ApiResult<Nothing>()
}
