package com.example.home

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.usecase.GetPokemonListUseCase
import com.example.home.common.HomeEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.ui.BaseSideEffect
import com.example.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : BaseViewModel<HomeEvent, HomeState, BaseSideEffect>() {

    override fun createInitialState(): HomeState = HomeState(homeUiState = HomeUiState.Loading)
    override fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.ClickFloatingBtn -> { }
            is HomeEvent.ClickSideFloatingBtn -> { }
            is HomeEvent.ClickSearchBtn -> { }
            is HomeEvent.ClickPokemonCard -> {
                setEffect(HomeSideEffect.StartDetailActivity(pokemon = event.pokemon))
            }
        }
    }

    fun getPokemonList(page: Int) {
        viewModelScope.launch {
            getPokemonListUseCase(page = page)
                .cachedIn(this)
                .collectLatest { pagingData ->
                    setState {
                        HomeState(homeUiState = HomeUiState.Success(pokemonList = flowOf(pagingData)))
                    }
            }
        }
    }

    fun callClickCircleMenuBtnEvent(){
        viewModelScope.launch {
            setEvent(HomeEvent.ClickFloatingBtn)
        }
    }
}