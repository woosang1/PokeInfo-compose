package com.example.data.network

sealed class ApiResult<out T> {
    data class Success<out T>(val value: T): ApiResult<T>()
    data class Error(val exception: Throwable? = null): ApiResult<Nothing>()
}
