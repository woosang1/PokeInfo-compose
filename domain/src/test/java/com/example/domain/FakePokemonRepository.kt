package com.example.domain

import androidx.paging.PagingData
import com.example.domain.repository.PokemonRepository
import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class FakePokemonRepository: PokemonRepository {
    override fun getPokemonList(page: Int): Flow<PagingData<Pokemon>> {
        val dummyList = listOf(
            Pokemon(name = "피카츄", url = "https://pokeapi.co/api/v2/pokemon/25/"),
            Pokemon(name = "이상해씨", url = "https://pokeapi.co/api/v2/pokemon/1/")
        )
        return flowOf(PagingData.from(dummyList))
    }

    override suspend fun getPokemonInfo(id: Int): Pokemon {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonSpeciesInfo(id: Int): Pokemon {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonTypeInfo(type: String): PokemonType {
        TODO("Not yet implemented")
    }

    override suspend fun getLikePokemonList(): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertLocalDB(pokemon: Pokemon) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteLocalDB(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun clearLocalDB() {
        TODO("Not yet implemented")
    }
}