package com.example.home.common

import com.example.domain.model.PokemonInfo
import com.example.ui.SideEffect
import kotlinx.collections.immutable.ImmutableList

sealed class HomeSideEffect: SideEffect {
    data class ShowFavoriteBottomSheet(val pokemonInfoList: ImmutableList<PokemonInfo>) : HomeSideEffect()
    data class ShowAllTypeBottomSheet(val pokemonInfoList: ImmutableList<PokemonInfo>) : HomeSideEffect()
    data class ShowGenerationsBottomSheet(val pokemonInfoList: ImmutableList<PokemonInfo>) : HomeSideEffect()
    data object ShowSearchBottomSheet: HomeSideEffect()
    data object CloseBottomSheet: HomeSideEffect()
    data class ShowToast(val message: String) : HomeSideEffect()
    data class StartDetailActivity(val pokemon: PokemonInfo.Pokemon) : HomeSideEffect()
}