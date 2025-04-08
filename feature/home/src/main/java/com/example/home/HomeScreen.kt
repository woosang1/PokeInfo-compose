package com.example.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.home.common.HomeEvent
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.home.view.FloatingButton
import com.example.home.view.GridCardLayout
import com.example.log.DebugLog
import com.example.ui.R

@Composable
fun HomeScreen(
    state: HomeState,
    onInit:() -> Unit,
    onEvent: (HomeEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        DebugLog("HomeScreen - LaunchedEffect(Unit)")
        onInit.invoke()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // 좌상단 이미지
        Image(
            painter = painterResource(id = R.drawable.pokeball),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(300.dp)
                .offset(x = 200.dp, y = (-100).dp)
                .alpha(0.25f),
            contentScale = ContentScale.Fit
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp)
        ) {
            // 타이틀
            Text(
                text = "Pokedex",
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 2.dp),
                textAlign = TextAlign.Start,
                style = LocalTypography.current.headline1,
                color = LocalColors.current.black,
                maxLines = 1
            )

            when(val mainUiState = state.homeUiState){
                is HomeUiState.Init -> Unit
                is HomeUiState.Empty -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(LocalColors.current.white)
                    ) {  }
                }
                is HomeUiState.Content -> {
                    val pokeList = mainUiState.pokemonList.collectAsLazyPagingItems()
                    GridCardLayout(
                        columns = 2,
                        modifier = Modifier,
                        paddingValues = 16,
                        horizontalArrangement = 8,
                        verticalArrangement = 8,
                        cardList = pokeList,
                        onClickPokemonCard = { pokemon ->
                            onEvent.invoke(HomeEvent.ClickPokemonCard(pokemon = pokemon))
                        }
                    )
                }
            }
        }

        // 좌하단 플로팅 버튼
        FloatingButton(
            modifier = Modifier
                .padding(end = 16.dp, bottom = 16.dp)
                .align(Alignment.BottomEnd),
            onClickGeneration = {
                onEvent.invoke(HomeEvent.ClickFloatingBtn)
            }
        )
    }
}