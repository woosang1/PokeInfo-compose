package com.example.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetryInterceptor @Inject constructor() : Interceptor {
    
    private val maxRetries = 3
    private val retryDelayMs = 1000L
    
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var response: Response? = null
        var exception: IOException? = null
        
        repeat(maxRetries) { attempt ->
            try {
                response?.close() // 이전 응답이 있다면 닫기
                response = chain.proceed(request)
                
                // 성공적인 응답이면 반환
                if (response!!.isSuccessful) {
                    return response!!
                }
                
                // 5xx 서버 에러인 경우 재시도
                if (response!!.code in 500..599) {
                    if (attempt < maxRetries - 1) {
                        Thread.sleep(retryDelayMs * (attempt + 1)) // 지수 백오프
                        return@repeat
                    }
                } else {
                    // 다른 HTTP 에러는 재시도하지 않음
                    return response!!
                }
                
            } catch (e: IOException) {
                exception = e
                
                // 재시도 가능한 에러인지 확인
                if (isRetryableException(e) && attempt < maxRetries - 1) {
                    try {
                        Thread.sleep(retryDelayMs * (attempt + 1))
                    } catch (ie: InterruptedException) {
                        Thread.currentThread().interrupt()
                        throw IOException("Interrupted during retry", ie)
                    }
                } else {
                    return@repeat
                }
            }
        }
        
        // 모든 재시도가 실패한 경우
        throw exception ?: IOException("Network request failed after $maxRetries attempts")
    }
    
    private fun isRetryableException(e: IOException): Boolean {
        return when (e) {
            is SocketTimeoutException,
            is UnknownHostException -> true
            else -> false
        }
    }
}
