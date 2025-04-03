package com.example.home.common

import com.example.domain.model.Pokemon
import com.example.domain.model.PokemonList
import com.example.base.BaseSideEffect
import kotlinx.collections.immutable.ImmutableList

sealed class HomeSideEffect: BaseSideEffect() {
    data class ShowFavoriteBottomSheet(val pokemonListList: ImmutableList<PokemonList>) : HomeSideEffect()
    data class ShowAllTypeBottomSheet(val pokemonListList: ImmutableList<PokemonList>) : HomeSideEffect()
    data class ShowGenerationsBottomSheet(val pokemonListList: ImmutableList<PokemonList>) : HomeSideEffect()
    data object ShowSearchBottomSheet: HomeSideEffect()
    data object CloseBottomSheet: HomeSideEffect()
    data class StartDetailActivity(val pokemon: Pokemon) : HomeSideEffect()
}