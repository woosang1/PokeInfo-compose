package com.example.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.detail.navigation.detailNavGraph
import com.example.home.navigation.homeNavGraph
import com.example.home.navigation.navigationMain
import com.example.navigation.Route


@Composable
internal fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: NavHostController
) {
    NavHost(
        navController = navigator,
        startDestination = Route.Home
    ) {
        homeNavGraph(onStartDetail = { navigator.navigationMain() })
        detailNavGraph()
        // TODO: 추후 화면 들어올 예정
//            detailNavGraph()
    }
}