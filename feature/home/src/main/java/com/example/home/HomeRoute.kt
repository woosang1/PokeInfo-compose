package com.example.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.component.LoadingAnimation
import com.example.home.common.HomeEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeUiState
import com.example.home.component.GenerationBottomSheet
import com.example.utils.UiError
import com.example.utils.extension.isDualScreen
import com.example.utils.extension.showToast
import com.example.utils.state.rememberFoldableState

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onClickItem: (String) -> Unit
) {
    val context = LocalContext.current

    val foldableState by rememberFoldableState(context)
    val isDualScreen = foldableState?.isDualScreen() ?: false
    val state by homeViewModel.state.collectAsStateWithLifecycle()

    val isShowGenerationSheet = rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(homeViewModel) {
        homeViewModel.effect.collect { effect ->
            when (effect) {
                is HomeSideEffect.ShowFavoriteBottomSheet -> {}
                is HomeSideEffect.ShowGenerationsBottomSheet -> {
                    isShowGenerationSheet.value = true
                }
                is HomeSideEffect.ShowSearchBottomSheet -> {}
                is HomeSideEffect.ShowToast -> context.showToast(effect.message)
                is HomeSideEffect.StartDetailActivity -> {
                    onClickItem(effect.pokemon.id.toString())
                }
                is HomeSideEffect.HandleNetworkUI -> {
                    context.showToast(effect.uiError.message)
                    when(effect.uiError){
                        is UiError.AuthError -> Unit
                        is UiError.NetworkError -> Unit
                        is UiError.PermissionError -> Unit
                        is UiError.ServerError -> Unit
                        is UiError.UnknownError -> Unit
                    }
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HomeScreen(
            state = state,
            isDualScreen = isDualScreen,
            onEvent = { event -> homeViewModel.setEvent(event) }
        )

        val uiState = state.homeUiState
        (uiState as? HomeUiState.Content)?.let {
            val pokeList = uiState.pokemonList.collectAsLazyPagingItems()
            val isEmpty = (pokeList.itemCount == 0)
            if (pokeList.loadState.refresh is LoadState.Loading || isEmpty) { LoadingAnimation() }
        }

        if (isShowGenerationSheet.value) {
            GenerationBottomSheet(
                modifier = Modifier.align(Alignment.BottomCenter),
                onClickItem = { homeViewModel.setEvent(HomeEvent.SelectGeneration(it)) },
                onHide = { isShowGenerationSheet.value = false }
            )
        }
    }

}