package com.example.data.di

import com.example.data.repository.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideMainHomeSection(pokemonRepositoryImpl : PokemonRepositoryImpl): com.example.domain.repository.PokemonRepository
}



