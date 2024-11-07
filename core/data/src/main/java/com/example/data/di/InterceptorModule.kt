package com.example.data.di

import com.example.data.network.interceptor.LogInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InterceptorModule {

    @Provides
    @Singleton
    fun provideLogInterceptor(): LogInterceptor = LogInterceptor()

}