package com.example.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.home.navigation.homeNavGraph
import com.example.home.navigation.navigationMain
import com.example.navigation.Route


@Composable
internal fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: NavHostController
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
    {
        NavHost(
            navController = navigator,
            startDestination = Route.Main.toString()
        ) {
            homeNavGraph(
                onMainClick = {
                    navigator.navigationMain()
                }
            )
            // TODO: 추후 화면 들어올 예정
//            detailNavGraph()
        }
    }
}