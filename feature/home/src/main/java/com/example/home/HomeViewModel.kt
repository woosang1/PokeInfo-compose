package com.example.home

import androidx.lifecycle.viewModelScope
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

    fun getPokemonInfo(limit: Int?, offset: Int?) {
        DebugLog("vm - getPokemonInfo")
        DebugLog("limit : ${limit}")
        DebugLog("offset : ${offset}")
        viewModelScope.launch {
            getPokemonInfoUseCase.getInfo(
                limit = limit,
                offset = offset
            ).collectLatest { result ->
                DebugLog("result : ${result.toString()}")
                setState {
                    if (result.results.isNotEmpty()) HomeState(homeUiState = HomeUiState.Result(pokemonList = result.results.toImmutableList()))
                    else HomeState(homeUiState = HomeUiState.Empty)
                }
            }
        }
    }
}