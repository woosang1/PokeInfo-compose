package com.example.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.base.base.BaseSideEffect
import com.example.base.base.BaseViewModel
import com.example.domain.usecase.GetLikePokemonListUseCase
import com.example.domain.usecase.GetPokemonListUseCase
import com.example.home.common.HomeEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.home.common.MenuType
import com.example.home.common.getIdRangeForGeneration
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val getLikePokemonListUseCase: GetLikePokemonListUseCase
) : BaseViewModel<HomeEvent, HomeState, BaseSideEffect>() {

    override fun createInitialState(): HomeState = HomeState(homeUiState = HomeUiState.Init)
    override fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnInit -> { checkLoading() }
            is HomeEvent.ClickFloatingBtn -> {
                when(event.menuType){
                    MenuType.LIKE -> {
                        viewModelScope.launch {
                            val likePokemonList = getLikePokemonListUseCase()
                            setState {
                                copy(
                                    homeUiState = HomeUiState.Content(
                                        pokemonList = likePokemonList.map { PagingData.from(it) }
                                    )
                                )
                            }
                        }
                    }
                    MenuType.SEARCH -> {}
                    MenuType.HOME -> {
                        setEffect(HomeSideEffect.ShowLoadingAnimation)
                        getPokemonList(page = 0)
                    }
                    MenuType.GENERATION -> { setEffect(HomeSideEffect.ShowGenerationsBottomSheet) }
                }
            }
            is HomeEvent.ClickPokemonCard -> {
                setEffect(HomeSideEffect.StartDetailActivity(pokemon = event.pokemon))
            }

            is HomeEvent.SelectGeneration -> {
                viewModelScope.launch {
                    setEffect(HomeSideEffect.ShowLoadingAnimation)
                    getPokemonList(page = 0, generation = event.generation)
                }
            }
            is HomeEvent.OnPagingError -> {
                setState { copy(homeUiState = HomeUiState.Error) }
                setEffect(HomeSideEffect.HideLoadingAnimation)
                setEffect(BaseSideEffect.ShowToast(event.message))
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
                .catch { e ->
                    setState { copy(homeUiState = HomeUiState.Error) }
                    e.message?.let { setEffect(BaseSideEffect.ShowToast(it)) }
                }
                .collectLatest { filteredPagingData ->
                    setState {
                        copy(
                            homeUiState = HomeUiState.Content(
                                pokemonList = flowOf(filteredPagingData)
                            )
                        )
                    }
                }
        }
    }
}