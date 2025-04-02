package com.example.home.common

import com.example.domain.model.Pokemon
import com.example.domain.model.PokemonList
import com.example.ui.BaseSideEffect
import com.example.ui.SideEffect
import kotlinx.collections.immutable.ImmutableList

sealed class HomeSideEffect: BaseSideEffect() {
    data class ShowFavoriteBottomSheet(val pokemonListList: ImmutableList<com.example.domain.model.PokemonList>) : HomeSideEffect()
    data class ShowAllTypeBottomSheet(val pokemonListList: ImmutableList<com.example.domain.model.PokemonList>) : HomeSideEffect()
    data class ShowGenerationsBottomSheet(val pokemonListList: ImmutableList<com.example.domain.model.PokemonList>) : HomeSideEffect()
    data object ShowSearchBottomSheet: HomeSideEffect()
    data object CloseBottomSheet: HomeSideEffect()
    data class StartDetailActivity(val pokemon: com.example.domain.model.Pokemon) : HomeSideEffect()
}