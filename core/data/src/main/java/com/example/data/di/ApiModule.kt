package com.example.data.di

import com.example.data.network.NetworkAPI
import com.example.data.network.gistGithubUrl
import com.example.data.network.interceptor.LogInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

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
            .baseUrl(gistGithubUrl)
            .client(okHttpClient)
            .build()
            .create(NetworkAPI::class.java)
}