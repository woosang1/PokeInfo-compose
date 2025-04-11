package com.example.home.view

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.designsystem.theme.LocalColors
import de.charlex.compose.SpeedDialData
import de.charlex.compose.SpeedDialFloatingActionButton
import com.example.resource.R as ResourceR

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun FloatingButton(
    modifier: Modifier,
    buttonList: List<String>,
    onClickHome: () -> Unit,
    onClickLike: () -> Unit,
    onClickSearch: () -> Unit,
    onClickGeneration: () -> Unit
) {
    SpeedDialFloatingActionButton(
        modifier = modifier,
        initialExpanded = false,
        animationDuration = 300,
        animationDelayPerSelection = 100,
        showLabels = true,
        fabBackgroundColor = LocalColors.current.lightBlue,
        fabContentColor = LocalColors.current.blue,
        speedDialBackgroundColor = LocalColors.current.lightBlue,
        speedDialContentColor = LocalColors.current.white,
        speedDialData = listOf(
            Triple(buttonList[0], ResourceR.drawable.filter, onClickHome),
            Triple(buttonList[1], ResourceR.drawable.filter, onClickLike),
            Triple(buttonList[2], ResourceR.drawable.filter, onClickSearch),
            Triple(buttonList[3], ResourceR.drawable.filter, onClickGeneration),
        ).map { (label, iconRes, onClick) ->
            SpeedDialData(
                label = label,
                painter = painterResource(id = iconRes),
                onClick = onClick
            )
        }
    )
}