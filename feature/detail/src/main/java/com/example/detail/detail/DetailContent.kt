package com.example.detail.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import coil.compose.AsyncImage
import com.example.component.CircleView
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.detail.about.aboutNavGraph
import com.example.detail.about.toAboutModel
import com.example.detail.baseStats.baseStatsNavGraph
import com.example.detail.detail.common.DetailEvent
import com.example.detail.evolution.evolutionNavGraph
import com.example.detail.moves.movesNavGraph
import com.example.utils.extension.getHeightDisplay
import com.example.utils.extension.pxToDp
import com.example.model.ui.Pokemon
import com.example.navigation.DetailTabRoute
import com.example.navigation.DetailTabRoute.Companion.getIndex
import kotlinx.serialization.json.Json

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    pokemon: Pokemon,
    onEvent: (DetailEvent) -> Unit
) {
    Box {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            // 이름 + ID
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = pokemon.name,
                    modifier = Modifier
                        .weight(1f),
                    style = LocalTypography.current.headline1,
                    color = LocalColors.current.white,
                    maxLines = 1,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "#${pokemon.id}",
                    modifier = Modifier.weight(1f),
                    style = LocalTypography.current.headline2,
                    color = LocalColors.current.white,
                    maxLines = 1,
                    textAlign = TextAlign.End
                )
            }

            // 타입
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                itemsIndexed(pokemon.types.take(2)) { index, type -> // 최대 2개까지만 표시
                    CircleView(
                        modifier = Modifier.padding(start = if (index > 0) 8.dp else 0.dp),
                        title = type
                    )
                }
            }

            // 이미지 (가운데 정렬 + 위쪽 마진)
            AsyncImage(
                model = pokemon.thumbnailUrl,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                placeholder = null
            )
        }
        PokemonInfoBottomSheet(
            modifier = modifier,
            pokemon = pokemon,
            onEvent = onEvent
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonInfoBottomSheet(
    modifier: Modifier,
    navigator: DetailNavigator = rememberDetailNavigator(),
    pokemon: Pokemon,
    onEvent: (DetailEvent) -> Unit
) {
    var selectedTab by remember { mutableStateOf(DetailTabRoute.tabList.first()) }

    val context = LocalContext.current
    val height = (context.getHeightDisplay() / 2).pxToDp()

    val bottomSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.PartiallyExpanded,
        skipHiddenState = true
    )

    val focusManager = LocalFocusManager.current
    var isSheetVisible by remember { mutableStateOf(true) }

    LaunchedEffect(bottomSheetState.targetValue) {
        isSheetVisible = bottomSheetState.targetValue != SheetValue.Hidden
    }

    BottomSheetScaffold(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(LocalColors.current.softGreen)
            .clickable(enabled = !isSheetVisible) {
                focusManager.clearFocus()
            },
        sheetContent = {
            FixedTabs(
                selectedTabIndex = selectedTab.getIndex(),
                onTabSelected = { index ->
                    selectedTab = DetailTabRoute.tabList[index]
                }
            )
            Box(modifier = Modifier.fillMaxSize()) {
                NavHost(
                    navController = navigator.navController,
                    startDestination = DetailTabRoute.About(modelJsonStr = Json.encodeToString(pokemon.toAboutModel()))
                ) {
                    aboutNavGraph()
                    baseStatsNavGraph()
                    evolutionNavGraph()
                    movesNavGraph()
                }
            }
        },
        scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState),
        sheetPeekHeight = height.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetSwipeEnabled = true
    ) { paddingValues -> }

    LaunchedEffect(selectedTab) { navigator.navigate(tab = selectedTab, pokemon = pokemon) }
}

@Composable
fun FixedTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Transparent
    ) {
        DetailTabRoute.tabList.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    onTabSelected(index)
                }
            ) {
                TabContent(text = tab.title)
            }
        }
    }
}

@Composable
fun TabContent(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.Center),
            style = LocalTypography.current.subTitle,
            color = LocalColors.current.black,
            maxLines = 1
        )
    }
}

