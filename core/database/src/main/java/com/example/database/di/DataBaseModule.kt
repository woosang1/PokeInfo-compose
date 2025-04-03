package com.example.database.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.database.POKEMON_INFO_DATASTORE
import com.example.database.dataStore.PokemonInfoDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun providePokemonInfoDataStore(
        @Named(POKEMON_INFO_DATASTORE) dataStore: DataStore<Preferences>
    ): PokemonInfoDataStore = PokemonInfoDataStore(dataStore)

}