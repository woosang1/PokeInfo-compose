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
            SpeedDialData(
                label = "??",
                painter = painterResource(id = ResourceR.drawable.filter)
            ) {
                //TODO onClick
            },
            SpeedDialData(
                label = "찜",
                painter = painterResource(id = ResourceR.drawable.filter)
            ) {
                //TODO onClick
            },
            SpeedDialData(
                label = "검색",
                painter = painterResource(id = ResourceR.drawable.filter)
            ) {
                //TODO onClick
            },
            SpeedDialData(
                label = "세대",
                painter = painterResource(id = ResourceR.drawable.filter)
            ) {
                onClickGeneration.invoke()
            }
        )
    )
}