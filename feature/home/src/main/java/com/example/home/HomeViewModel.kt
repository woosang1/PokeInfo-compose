package com.example.home

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.domain.usecase.GetPokemonListUseCase
import com.example.home.common.HomeEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.base.base.BaseSideEffect
import com.example.base.base.BaseViewModel
import com.example.home.common.getIdRangeForGeneration
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : BaseViewModel<HomeEvent, HomeState, BaseSideEffect>() {

    override fun createInitialState(): HomeState = HomeState(homeUiState = HomeUiState.Init)
    override fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.ClickFloatingBtn -> {
                // TODO: 먼저 구현.
                setEffect(HomeSideEffect.ShowGenerationsBottomSheet)
            }

            is HomeEvent.ClickSideFloatingBtn -> {}
            is HomeEvent.ClickSearchBtn -> {}
            is HomeEvent.ClickPokemonCard -> {
                setEffect(HomeSideEffect.StartDetailActivity(pokemon = event.pokemon))
            }

            is HomeEvent.SelectGeneration -> {
                viewModelScope.launch {
                    setEffect(HomeSideEffect.ShowLoadingAnimation)
                    getPokemonList(page = 0, generation = event.generation)
                }
            }
        }
    }

    fun checkLoading() {
        if (state.value.homeUiState !is HomeUiState.Content) {
            setEffect(HomeSideEffect.ShowLoadingAnimation)
            getPokemonList(page = 0)
        }
    }

    private fun getPokemonList(page: Int, generation: Int? = null) {
        viewModelScope.launch {
            val idRange = generation?.let { getIdRangeForGeneration(it) }
            getPokemonListUseCase(page = page)
                .map { pagingData ->
                    idRange?.let { range ->
                        pagingData.filter { it.id in range }
                    } ?: pagingData
                }
                .cachedIn(this)
                .collectLatest { filteredPagingData ->
                    setState {
                        copy(
                            homeUiState = HomeUiState.Content(
                                pokemonList = flowOf(filteredPagingData)
                            )
                        )
                    }
                    setEffect(HomeSideEffect.HideGenerationsBottomSheet)
                }
        }
    }
}