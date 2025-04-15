package com.example.data.di

import com.example.data.datasource.local.PokemonInfoLocalDataSource
import com.example.data.datasource.local.PokemonInfoLocalDataSourceImpl
import com.example.data.datasource.remote.PokemonRemoteDataSource
import com.example.data.datasource.remote.PokemonRemoteDataSourceImpl
import com.example.database.room.PokemonDao
import com.example.network.PokemonAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providePokemonRemoteDataSource(
        pokemonApi: PokemonAPI
    ): PokemonRemoteDataSource {
        return PokemonRemoteDataSourceImpl(pokemonApi)
    }

    @Provides
    @Singleton
    fun providePokemonInfoLocalDataSource(
        pokemonDao: PokemonDao
    ): PokemonInfoLocalDataSource {
        return PokemonInfoLocalDataSourceImpl(pokemonDao)
    }
}
