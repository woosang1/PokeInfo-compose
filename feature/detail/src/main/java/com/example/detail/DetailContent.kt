package com.example.detail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import com.example.designsystem.theme.LocalTypography
import com.example.navigation.DetailTabRouteModel
import com.example.extension.getHeightDisplay
import com.example.extension.pxToDp
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    onBackEvent: () -> Unit
) {
    PokemonInfoBottomSheet(
        modifier = modifier,
        onBackEvent = onBackEvent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonInfoBottomSheet(
    modifier: Modifier,
    onBackEvent: () -> Unit
) {

    val context = LocalContext.current
    val height = (context.getHeightDisplay() / 2).pxToDp()

    val bottomSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.PartiallyExpanded,
        skipHiddenState = false
    )

    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    var isSheetVisible by remember { mutableStateOf(true) }

    LaunchedEffect(bottomSheetState.targetValue) {
        isSheetVisible = bottomSheetState.targetValue != SheetValue.Hidden
    }

    BackHandler(enabled = isSheetVisible) {
        scope.launch { bottomSheetState.hide() }
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
                onTabSelected = { index -> }
            )
        },
        scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState),
        sheetPeekHeight = height.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    ) { paddingValues -> }
}

@Composable
fun FixedTabs(
    onTabSelected: (Int) -> Unit
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Transparent
    ) {
        DetailTabRouteModel.tabList.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index // 선택된 탭 변경
                    onTabSelected(index) // 외부 콜백 호출
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
            style = LocalTypography.current.title4,
            color = LocalColors.current.black,
            maxLines = 1
        )
    }
}

