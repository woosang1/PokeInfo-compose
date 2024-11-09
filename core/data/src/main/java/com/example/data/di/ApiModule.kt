package com.example.data.di

import com.example.data.network.NetworkAPI
import com.example.data.network.pokeApiUrl
import com.example.data.network.interceptor.LogInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideOkhttpClient(
        logInterceptor: LogInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideNetworkAPI(
        okHttpClient: OkHttpClient,
    ): NetworkAPI =
        Retrofit.Builder()
            .baseUrl(pokeApiUrl)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(NetworkAPI::class.java)
}