package com.example.database.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.database.POKEMON_INFO_DATASTORE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    private const val POKEMON_INFO_DATASTORE_NAME = "POKEMON_INFO_PREFERENCES"

    private val Context.pokemonInfoDataStore by preferencesDataStore(POKEMON_INFO_DATASTORE_NAME)

    @Provides
    @Singleton
    @Named(POKEMON_INFO_DATASTORE)
    fun providePokemonDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> = context.pokemonInfoDataStore
}