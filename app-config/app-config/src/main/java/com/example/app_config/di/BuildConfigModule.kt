package com.example.app_config.di

import com.example.app_config.PokeInfoBuildConfigImpl
import com.example.app_config_api.PokeInfoBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object BuildConfigModule {

    @Provides
    @Singleton
    fun providePokeInfoBuildConfig(
        impl: PokeInfoBuildConfigImpl
    ): PokeInfoBuildConfig = impl
}

