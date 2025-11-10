package com.example.network.di

import com.example.app_config_api.PokeInfoBuildConfig
import com.example.network.PokemonAPI
import com.example.network.interceptor.LogInterceptor
import com.example.network.interceptor.RetryInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideConverterFactory(
        json: Json,
    ): Converter.Factory {
        return json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(
        @ApplicationContext context: android.content.Context,
        logInterceptor: LogInterceptor,
        retryInterceptor: RetryInterceptor
    ): OkHttpClient {
        // 네트워크 캐시 설정
        val cacheSize = 10 * 1024 * 1024L // 10MB
        val cacheDirectory = File(context.cacheDir, "http_cache")
        val cache = Cache(cacheDirectory, cacheSize)
        
        return OkHttpClient.Builder()
            .addInterceptor(retryInterceptor) // 재시도 인터셉터 추가
            .addInterceptor(logInterceptor)
            .cache(cache) // HTTP 캐시 활성화
            .build()
    }

    @Provides
    @Singleton
    fun provideNetworkAPI(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        buildConfig: PokeInfoBuildConfig,
    ): PokemonAPI =
        Retrofit.Builder()
            .baseUrl(buildConfig.getNetworkUrl())
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(PokemonAPI::class.java)

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
}