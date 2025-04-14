package com.example.home.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.extension.getHeightDisplay
import com.example.extension.noRippleClickable
import com.example.extension.pxToDp
import com.example.home.model.GenerationItemData
import com.example.log.DebugLog
import com.example.resource.R as ResourceR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenerationBottomSheet(
    modifier: Modifier = Modifier,
    onClickItem: (Int) -> Unit,
    onHide: () -> Unit
) {

    val context = LocalContext.current
    val height = (context.getHeightDisplay() / 2).pxToDp()

    val bottomSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.PartiallyExpanded,
        skipHiddenState = true
    )

    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    var isSheetVisible by remember { mutableStateOf(true) }

    LaunchedEffect(bottomSheetState.targetValue) {
        DebugLog("- LaunchedEffect(bottomSheetState.targetValue) -")
        isSheetVisible = bottomSheetState.targetValue != SheetValue.Hidden
        DebugLog("- isSheetVisible : ${isSheetVisible} -")
    }

    BackHandler(enabled = isSheetVisible) {
        DebugLog("- BackHandler -")
        onHide.invoke()
    }

    // 외부 클릭 시 바텀시트 닫기
    Box(modifier =
        Modifier.fillMaxSize()
            .fillMaxSize()
            .background(Color.Transparent)
            .clickable { if(isSheetVisible) onHide.invoke() }
    ) {
        BottomSheetScaffold(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(enabled = !isSheetVisible) {
                    focusManager.clearFocus()
                },
            sheetContent = {
                GenerationContent(onClickItem = onClickItem)
            },
            scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState),
            sheetPeekHeight = height.dp,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetSwipeEnabled = true
        ) { paddingValues -> }
    }
}

@Composable
fun GenerationContent(
    onClickItem: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Generation",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = LocalTypography.current.headline2,
            color = LocalColors.current.black,
            maxLines = 1
        )

        val generations = listOf(
            GenerationItemData(generation = 1, "1세대", ResourceR.drawable.gen1),
            GenerationItemData(generation = 2, "2세대", ResourceR.drawable.gen2),
            GenerationItemData(generation = 3, "3세대", ResourceR.drawable.gen3),
            GenerationItemData(generation = 4, "4세대", ResourceR.drawable.gen4),
            GenerationItemData(generation = 5, "5세대", ResourceR.drawable.gen5),
            GenerationItemData(generation = 6, "6세대", ResourceR.drawable.gen6),
            GenerationItemData(generation = 7, "7세대", ResourceR.drawable.gen7),
            GenerationItemData(generation = 8, "8세대", ResourceR.drawable.gen8)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(generations, key = {it.generation }) { generation ->
                GenerationItem(
                    generationItemData = generation,
                    onClickItem = { onClickItem.invoke(it) }
                )
            }
        }
    }
}

@Composable
fun GenerationItem(
    generationItemData: GenerationItemData,
    onClickItem: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f) // 가로:세로 = 3:2
            .border(1.dp, LocalColors.current.gray, RoundedCornerShape(8.dp))
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(LocalColors.current.white)
            .padding(8.dp)
            .noRippleClickable { onClickItem.invoke(generationItemData.generation) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = generationItemData.title,
            style = LocalTypography.current.headline3,
            color = LocalColors.current.black,
            modifier = Modifier.padding(top = 8.dp)
        )

        Image(
            painter = painterResource(id = generationItemData.imageRes),
            contentDescription = "",
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
    }
}
