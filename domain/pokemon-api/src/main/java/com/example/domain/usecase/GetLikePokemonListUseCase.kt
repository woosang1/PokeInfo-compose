package com.example.domain.usecase

import com.example.model.ui.Pokemon
import kotlinx.coroutines.flow.Flow

fun interface GetLikePokemonListUseCase {
    operator fun invoke(): Flow<List<Pokemon>>
}
