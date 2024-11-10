package com.example.home

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.usecase.GetPokemonInfoUseCase
import com.example.home.common.MainEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.log.DebugLog
import com.example.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase
) : BaseViewModel<MainEvent, HomeState, HomeSideEffect>() {

    override fun createInitialState(): HomeState = HomeState(homeUiState = HomeUiState.Init)
    override fun handleEvent(event: MainEvent) {
        when (event) {
            is MainEvent.ClickCircleMenuBtn -> { }
            is MainEvent.ClickSearchBtn -> { }
            is MainEvent.ClickPokemonCard -> {
                setEffect { HomeSideEffect.StartDetailActivity(pokemon = event.pokemon) }
            }
        }
    }

    fun getPokemonList(page: Int) {
        DebugLog("vm - getPokemonList [${page}]")
        viewModelScope.launch {
            DebugLog("- viewModelScope.launch -")
            getPokemonInfoUseCase.getInfo(page = page)
                .cachedIn(this)
                .collectLatest { pagingData ->
                    DebugLog(".collectLatest { pagingData ->")
                    DebugLog("pagingData : ${pagingData.toString()}")
                    setState {
                        HomeState(homeUiState = HomeUiState.Result(pokemonList = flowOf(pagingData)))
                    }
            }
        }
    }
}