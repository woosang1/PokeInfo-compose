package com.example.database.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.example.database.POKEMON_INFO_DATASTORE
import com.example.database.dataStore.PokemonInfoDataStore
import com.example.database.room.PokemonDao
import com.example.database.room.PokemonRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PokemonRoomDataBase =
        Room.databaseBuilder(
            context,
            PokemonRoomDataBase::class.java,
            "pokemon.dp"
        ).build()

    @Provides
    fun providePokemonDao(database: PokemonRoomDataBase): PokemonDao =
        database.pokemonDao()

    @Provides
    @Singleton
    fun providePokemonInfoDataStore(
        @Named(POKEMON_INFO_DATASTORE) dataStore: DataStore<Preferences>
    ): PokemonInfoDataStore = PokemonInfoDataStore(dataStore)



}