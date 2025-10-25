package com.example.detail.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import coil.compose.AsyncImage
import com.example.component.CircleView
import com.example.component.common.getPokemonColorType
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.detail.about.aboutNavGraph
import com.example.detail.about.toAboutModel
import com.example.detail.baseStats.baseStatsNavGraph
import com.example.detail.detail.common.DetailEvent
import com.example.detail.evolution.evolutionNavGraph
import com.example.detail.moves.movesNavGraph
import com.example.model.ui.AboutModel
import com.example.model.ui.Pokemon
import com.example.navigation.DetailTabRoute
import com.example.navigation.DetailTabRoute.Companion.getIndex
import com.example.utils.extension.getHeightDisplay
import com.example.utils.extension.pxToDp
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

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
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            
            // 이름 + ID 섹션
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = pokemon.name.replaceFirstChar { it.uppercase() },
                        style = LocalTypography.current.headline1.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = LocalColors.current.white,
                        maxLines = 1
                    )
                    
                    // 기본 정보 (키, 무게)
                    Row(
                        modifier = Modifier.padding(top = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        InfoChip(
                            label = "Height",
                            value = "${pokemon.height / 10.0}m"
                        )
                        InfoChip(
                            label = "Weight", 
                            value = "${pokemon.weight / 10.0}kg"
                        )
                    }
                }

                Text(
                    text = "#${pokemon.id.toString().padStart(3, '0')}",
                    style = LocalTypography.current.headline2.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = LocalColors.current.white.copy(alpha = 0.8f),
                    maxLines = 1
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 타입 섹션
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                pokemon.types.take(2).forEach { type ->
                    TypeChip(
                        type = type,
                        modifier = Modifier
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 포켓몬 이미지 섹션
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                // 배경 원형 효과
                Box(
                    modifier = Modifier
                        .size(280.dp)
                        .align(Alignment.Center)
                        .background(
                            color = Color.White.copy(alpha = 0.1f),
                            shape = CircleShape
                        )
                )
                
                // 포켓몬 이미지
                AsyncImage(
                    model = pokemon.thumbnailUrl,
                    modifier = Modifier
                        .size(240.dp)
                        .align(Alignment.Center)
                        .shadow(
                            elevation = 8.dp,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Fit,
                    contentDescription = null,
                    placeholder = null
                )
            }
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

    val bottomSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.PartiallyExpanded,
        skipHiddenState = false,
        confirmValueChange = { true }
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
                    startDestination = DetailTabRoute.About(modelJsonStr = Json.encodeToString<AboutModel>(pokemon.toAboutModel()))
                ) {
                    aboutNavGraph()
                    baseStatsNavGraph()
                    evolutionNavGraph()
                    movesNavGraph()
                }
            }
        },
        scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState),
        sheetPeekHeight = 300.dp, // 고정 높이 300dp
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetSwipeEnabled = true,
        sheetDragHandle = { 
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(8.dp)
                        .background(
                            color = Color.Gray.copy(alpha = 0.8f),
                            shape = RoundedCornerShape(4.dp)
                        )
                )
            }
        }
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        containerColor = Color.Transparent,
        indicator = { },
        divider = { }
    ) {
        DetailTabRoute.tabList.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    onTabSelected(index)
                },
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                TabContent(
                    text = tab.title,
                    isSelected = selectedTabIndex == index
                )
            }
        }
    }
}

@Composable
fun TabContent(
    text: String,
    isSelected: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 8.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            style = if (isSelected) {
                LocalTypography.current.body1.copy(
                    fontWeight = FontWeight.Bold
                )
            } else {
                LocalTypography.current.body1.copy(
                    fontWeight = FontWeight.Medium
                )
            },
            color = if (isSelected) {
                LocalColors.current.black
            } else {
                LocalColors.current.black.copy(alpha = 0.6f)
            },
            maxLines = 1
        )
    }
}

@Composable
private fun InfoChip(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    val chipShape = remember { RoundedCornerShape(12.dp) }
    
    Box(
        modifier = modifier
            .clip(chipShape)
            .background(Color.White.copy(alpha = 0.2f))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Column {
            Text(
                text = label,
                style = LocalTypography.current.caption1.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = LocalColors.current.white.copy(alpha = 0.8f)
            )
            Text(
                text = value,
                style = LocalTypography.current.body1.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = LocalColors.current.white
            )
        }
    }
}

@Composable
private fun TypeChip(
    type: String,
    modifier: Modifier = Modifier
) {
    val typeColor = remember(type) { type.getPokemonColorType() }
    val chipShape = remember { RoundedCornerShape(16.dp) }
    
    Box(
        modifier = modifier
            .clip(chipShape)
            .background(typeColor.copy(alpha = 0.9f))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = type.replaceFirstChar { it.uppercase() },
            style = LocalTypography.current.body1.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.White,
            maxLines = 1
        )
    }
}

