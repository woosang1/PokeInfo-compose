package com.example.data.di

import com.example.data.network.NetworkAPI
import com.example.data.network.pokeApiUrl
import com.example.data.network.interceptor.LogInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

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
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkAPI::class.java)
}