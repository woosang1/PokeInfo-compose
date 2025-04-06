package com.example.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.home.common.HomeSideEffect
import com.example.base.base.BaseSideEffect
import com.example.extension.showToast
import com.example.home.common.HomeEvent
import com.example.home.view.GenerationBottomSheet

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onClickItem: (String) -> Unit,
) {
    val context = LocalContext.current
    val uiState by homeViewModel.state.collectAsStateWithLifecycle()
    val sideEffect = homeViewModel.effect

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
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HomeScreen(
            state = uiState,
            onInit = { homeViewModel.checkLoading() },
            onEvent = { event -> homeViewModel.setEvent(event) }
        )
        if (isShowGenerationSheet.value) {
            GenerationBottomSheet(
                modifier = Modifier.align(Alignment.BottomCenter),
                onClickItem = { homeViewModel.setEvent(HomeEvent.SelectGeneration(it)) },
                onHide = { homeViewModel.setEffect(HomeSideEffect.HideGenerationsBottomSheet) }
            )
        }
    }

}