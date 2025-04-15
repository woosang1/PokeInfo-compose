package com.example.detail.detail

import androidx.lifecycle.viewModelScope
import com.example.base.base.BaseViewModel
import com.example.detail.detail.common.DetailEvent
import com.example.detail.detail.common.DetailSideEffect
import com.example.detail.detail.common.DetailState
import com.example.detail.detail.common.DetailUiState
import com.example.domain.usecase.DeletePokemonUseCase
import com.example.domain.usecase.GetLikePokemonListUseCase
import com.example.domain.usecase.GetPokemonDetailInfoUseCase
import com.example.domain.usecase.InsertPokemonUseCase
import com.example.utils.log.DebugLog
import com.example.utils.toUiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonDetailInfoUseCase: GetPokemonDetailInfoUseCase,
    private val getLikePokemonListUseCase: GetLikePokemonListUseCase,
    private val insertPokemonUseCase: InsertPokemonUseCase,
    private val deletePokemonUseCase: DeletePokemonUseCase,
) : BaseViewModel<DetailEvent, DetailState, DetailSideEffect>() {

    override fun createInitialState(): DetailState = DetailState(detailUiState = DetailUiState.Loading)
    override fun handleEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.ClickBackIcon -> { setEffect(DetailSideEffect.BackPage) }
            is DetailEvent.PressBackActionWithFirstTab -> { setEffect(DetailSideEffect.BackPage) }
            is DetailEvent.ClickLikeIcon -> {
                val isLike = event.isLike
                viewModelScope.launch {
                    (state.value.detailUiState as? DetailUiState.Result)?.let { result ->
                        val pokemon = result.pokemon
                        if (isLike) insertPokemonUseCase(pokemon = pokemon)
                        else deletePokemonUseCase(id = pokemon.id)
                        setEffect(DetailSideEffect.ShowToast(if (isLike)"좋아요가 추가되었습니다." else "좋아요를 취소했습니다."))
                        val updatedPokemon = result.pokemon.copy(isLike = isLike)
                        setState {
                            copy(detailUiState = result.copy(pokemon = updatedPokemon))
                        }
                    }
                }
            }
            is DetailEvent.SelectTab -> { }
        }
    }

    fun getPokemonDetailInfo(id: Int) {
        viewModelScope.launch {
            combine(
                getLikePokemonListUseCase(),
                flow { emit(getPokemonDetailInfoUseCase(id)) }
            ) { likeList, pokemon ->
                val isLiked = likeList.any { it.id == pokemon.id }
                pokemon.copy(isLike = isLiked)
            }.catch { e ->
                DebugLog("error : ${e.message}")
                setState { copy(detailUiState = DetailUiState.Empty) }
                setEffect(DetailSideEffect.HandleNetworkUI(e))
            }.collectLatest { updatedPokemon ->
                setState { copy(detailUiState = DetailUiState.Result(pokemon = updatedPokemon)) }
            }
        }
    }
}