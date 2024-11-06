package com.example.data.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


inline fun <T> safeFlow(crossinline networkCall: suspend () -> T): Flow<ApiResult<T>> = flow {
    val result = networkCall()
    if (result != null) {
        emit(ApiResult.Success(result))
    } else {
        emit(ApiResult.Error(NullPointerException("Network call returned null")))
    }
}.catch { exception ->
    emit(ApiResult.Error(exception))
}
