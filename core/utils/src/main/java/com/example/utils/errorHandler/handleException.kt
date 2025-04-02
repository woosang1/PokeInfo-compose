package com.example.utils.errorHandler

import okio.IOException
import retrofit2.HttpException

fun Throwable.toUiError(): UiError {
    return when (this) {
        is HttpException -> when (code()) {
            401 -> UiError.AuthError()
            403 -> UiError.PermissionError()
            else -> UiError.ServerError(code(), message ?: "")
        }
        is IOException -> UiError.NetworkError()
        else -> UiError.UnknownError("알 수 없는 오류 발생: ${message}")
    }
}