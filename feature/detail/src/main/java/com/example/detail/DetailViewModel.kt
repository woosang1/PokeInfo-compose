package com.example.detail

import androidx.lifecycle.viewModelScope
import com.example.detail.common.DetailEvent
import com.example.detail.common.DetailSideEffect
import com.example.detail.common.DetailState
import com.example.detail.common.DetailUiState
import com.example.domain.usecase.GetPokemonDetailInfoUseCase
import com.example.ui.BaseSideEffect
import com.example.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.utils.errorHandler.toUiError
import kotlinx.coroutines.flow.collectLatest

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonDetailInfoUseCase: GetPokemonDetailInfoUseCase
) : BaseViewModel<DetailEvent, DetailState, DetailSideEffect>() {

    override fun createInitialState(): DetailState = DetailState(detailUiState = DetailUiState.Loading)
    override fun handleEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.ClickBackIcon -> { }
            is DetailEvent.ClickLikeIcon -> { }
            is DetailEvent.SelectTab -> { }
        }
    }

    fun getPokemonDetailInfo(id: Int){
        viewModelScope.launch {
            flow { emit(getPokemonDetailInfoUseCase(id)) }
                .catch { throwable ->
                    setState { copy(detailUiState = DetailUiState.Empty) }
                    handlerError(throwable.toUiError())
                }
                .collectLatest { pokemon ->
                    // TODO: 여기 고쳐야함.
                    setState { copy(detailUiState = DetailUiState.Result) }
                }
        }
    }
}