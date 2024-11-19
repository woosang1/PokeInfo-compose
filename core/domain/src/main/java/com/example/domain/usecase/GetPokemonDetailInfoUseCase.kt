package com.example.domain.usecase

import com.example.domain.model.Pokemon
import com.example.domain.repository.PokemonRepository
import com.example.log.DebugLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonDetailInfoUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    operator fun invoke(id: Int, onError: (String) -> Unit): Flow<Pokemon> = flow {
        DebugLog("GetPokemonDetailInfoUseCase - invoke")
        val info = pokemonRepository.getPokemonInfo(id = id, onError = onError)
        info.collectLatest {
            emit(it)
        }
//        info.collectLatest { info ->
//            DebugLog("info -> ")
//            DebugLog("info : ${info.toString()}")
//            val type = info.types.firstOrNull()
//            type?.let { type ->
//                pokemonRepository.getPokemonTypeInfo(type = type, onError = onError)
//                    .collectLatest { it ->
//                        DebugLog("type ->")
//                        DebugLog("type : ${it.toString()}")
//                        emit(info.copy(pokemonType = it))
//                    }
//            }
//        }
    }
}