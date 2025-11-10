package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.model.ui.Pokemon
import kotlinx.coroutines.flow.Flow

fun interface GetPokemonListUseCase {
    operator fun invoke(page: Int): Flow<PagingData<Pokemon>>
}
