package com.example.network.di

import com.example.network.PokemonAPI
import com.example.network.interceptor.LogInterceptor
import com.example.network.pokeApiUrl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
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
        logInterceptor: LogInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideNetworkAPI(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): PokemonAPI =
        Retrofit.Builder()
            .baseUrl(pokeApiUrl)
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