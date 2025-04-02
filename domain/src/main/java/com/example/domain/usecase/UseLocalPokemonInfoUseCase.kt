package com.example.domain.usecase

import com.example.domain.repository.PokemonRepository
import javax.inject.Inject

class UseLocalPokemonInfoUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){
    fun insertLocalDB() { pokemonRepository.insertLocalDB() }
    fun clearLocalDB() { pokemonRepository.clearLocalDB() }
    fun deleteLocalDB(id: String) { pokemonRepository.deleteLocalDB(id) }

}