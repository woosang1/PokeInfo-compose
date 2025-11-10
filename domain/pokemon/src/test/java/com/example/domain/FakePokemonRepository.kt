package com.example.domain

import androidx.paging.PagingData
import com.example.data.repository.PokemonRepository
import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class FakePokemonRepository : PokemonRepository {
    override fun getPokemonList(page: Int): Flow<PagingData<Pokemon>> {
        val dummyList = listOf(
            Pokemon(name = "피카츄", thumbnailUrl = "https://pokeapi.co/api/v2/pokemon/25/"),
            Pokemon(name = "이상해씨", thumbnailUrl = "https://pokeapi.co/api/v2/pokemon/1/")
        )
        return flowOf(PagingData.from(dummyList))
    }

    override suspend fun getPokemonInfo(id: Int): Pokemon {
        throw NotImplementedError()
    }

    override suspend fun getPokemonSpeciesInfo(id: Int): Pokemon {
        throw NotImplementedError()
    }

    override suspend fun getPokemonTypeInfo(type: String): PokemonType {
        throw NotImplementedError()
    }

    override fun getLikePokemonList(): Flow<List<Pokemon>> {
        throw NotImplementedError()
    }

    override suspend fun insertLocalDB(pokemon: Pokemon) {
        throw NotImplementedError()
    }

    override suspend fun deleteLocalDB(id: Int) {
        throw NotImplementedError()
    }

    override suspend fun clearLocalDB() {
        throw NotImplementedError()
    }
}
