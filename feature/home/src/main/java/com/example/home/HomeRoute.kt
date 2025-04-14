package com.example.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.base.base.BaseSideEffect
import com.example.component.LoadingAnimation
import com.example.utils.extension.showToast
import com.example.home.common.HomeEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeUiState
import com.example.home.view.GenerationBottomSheet
import com.example.utils.state.rememberFoldableState
import com.example.utils.extension.isDualScreen

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onClickItem: (String) -> Unit,
) {
    val context = LocalContext.current

    val foldableState by rememberFoldableState(context)
    val isDualScreen = foldableState?.isDualScreen() ?: false

    val state by homeViewModel.state.collectAsStateWithLifecycle()
    val sideEffect = homeViewModel.effect

    val isLoadingAnimation = remember { mutableStateOf(false) }
    val isShowGenerationSheet = remember { mutableStateOf(false) }

    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when (effect) {
                is HomeSideEffect.CloseBottomSheet -> {}
                is HomeSideEffect.ShowAllTypeBottomSheet -> {}
                is HomeSideEffect.ShowFavoriteBottomSheet -> {}
                is HomeSideEffect.ShowGenerationsBottomSheet -> {
                    isShowGenerationSheet.value = true
                }
                is HomeSideEffect.HideGenerationsBottomSheet -> {
                    isShowGenerationSheet.value = false
                }
                is HomeSideEffect.ShowSearchBottomSheet -> {}
                is BaseSideEffect.ShowToast -> {
                    context.showToast(effect.message)
                }
                is HomeSideEffect.StartDetailActivity -> {
                    onClickItem.invoke(effect.pokemon.id.toString())
                }
                is HomeSideEffect.ShowLoadingAnimation -> {
                    isLoadingAnimation.value = true
                }
                is HomeSideEffect.HideLoadingAnimation -> {
                    isLoadingAnimation.value = false
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

        if (isLoadingAnimation.value){
            val uiState = state.homeUiState
            (uiState as? HomeUiState.Content)?.let {
                val pokeList = uiState.pokemonList.collectAsLazyPagingItems()
                val isEmpty = (pokeList.itemCount == 0)
                if (pokeList.loadState.refresh is LoadState.Loading || isEmpty) { LoadingAnimation() }
                else homeViewModel.setEffect(HomeSideEffect.HideLoadingAnimation)
            }
        }

        if (isShowGenerationSheet.value) {
            GenerationBottomSheet(
                modifier = Modifier.align(Alignment.BottomCenter),
                onClickItem = { homeViewModel.setEvent(HomeEvent.SelectGeneration(it)) },
                onHide = { homeViewModel.setEffect(HomeSideEffect.HideGenerationsBottomSheet) }
            )
        }
    }

}