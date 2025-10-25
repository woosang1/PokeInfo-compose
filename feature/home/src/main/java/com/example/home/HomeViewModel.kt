package com.example.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.base.base.BaseViewModel
import com.example.domain.usecase.GetLikePokemonListUseCase
import com.example.domain.usecase.GetPokemonListUseCase
import com.example.home.common.HomeEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.home.common.MenuType
import com.example.home.common.getIdRangeForGeneration
import com.example.model.ui.Pokemon
import com.example.utils.FeatureErrorHandler
import com.example.utils.toUiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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
) : BaseViewModel<HomeEvent, HomeState, HomeSideEffect>(), FeatureErrorHandler {

    override fun createInitialState(): HomeState = HomeState(homeUiState = HomeUiState.Init)
    override fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.Init -> { checkLoading() }
            is HomeEvent.ClickFloatingBtn -> {
                when (event.menuType) {
                    MenuType.LIKE -> {
                        val pagingFlow: Flow<PagingData<Pokemon>> =
                            getLikePokemonListUseCase()
                                .map { list -> PagingData.from(list) }
                                .cachedIn(viewModelScope)

                        setState {
                            copy(homeUiState = HomeUiState.Content(pokemonList = pagingFlow))
                        }
                    }
                    MenuType.SEARCH -> {}
                    MenuType.HOME -> { getPokemonList(page = 0) }
                    MenuType.GENERATION -> {
                        setEffect(HomeSideEffect.ShowGenerationsBottomSheet)
                    }
                }
            }

            is HomeEvent.ClickPokemonCard -> {
                setEffect(HomeSideEffect.StartDetailActivity(pokemon = event.pokemon))
            }

            is HomeEvent.SelectGeneration -> {
                getPokemonList(page = 0, generation = event.generation)
            }

            is HomeEvent.PagingError -> {
//                setEffect(HomeSideEffect.HideLoadingAnimation)
                handleError(event.e)
            }

            is HomeEvent.ClickReLoadBtn -> {
                getPokemonList(page = 0)
            }
        }
    }

    override fun handleError(throwable: Throwable) {
        setEffect(HomeSideEffect.HandleNetworkUI(throwable.toUiError()))
    }

    private fun checkLoading() {
        if (state.value.homeUiState !is HomeUiState.Content) {
            getPokemonList(page = 0)
        }
    }

    private fun getPokemonList(page: Int, generation: Int? = null) {
        val idRange = generation?.let { getIdRangeForGeneration(it) }
        val pagingFlow = getPokemonListUseCase(page = page)
            .map { pagingData ->
                idRange?.let { range -> pagingData.filter { it.id in range } } ?: pagingData
            }
            .cachedIn(viewModelScope)

        viewModelScope.launch {
            try {
                pagingFlow
                    .catch { e ->
                        setState { copy(homeUiState = HomeUiState.Error) }
                        handleError(throwable = e)
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
            } catch (e: Exception) {
                setState { copy(homeUiState = HomeUiState.Error) }
                handleError(throwable = e)
            }
        }
    }

}