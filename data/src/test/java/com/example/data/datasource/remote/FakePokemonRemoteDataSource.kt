package com.example.data.datasource.remote

import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonList
import com.example.model.rp.RpPokemonSpecies
import com.example.model.rp.RpPokemonType

internal class FakePokemonRemoteDataSource : PokemonRemoteDataSource {
    override suspend fun getPokemonList(page: Int, limit: Int): RpPokemonList {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonInfo(id: Int): RpPokemonInfo {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonSpeciesInfo(id: Int): RpPokemonSpecies {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonTypeInfo(type: String): RpPokemonType {
        TODO("Not yet implemented")
    }
}
