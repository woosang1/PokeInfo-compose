package com.example.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.detail.navigation.detailNavGraph
import com.example.home.navigation.homeNavGraph
import com.example.navigation.MainRoute


@Composable
internal fun MainNavHost(
    navigator: MainNavigator = rememberMainNavigator()
) {
    NavHost(
        navController = navigator.navController,
        startDestination = MainRoute.Home
    ) {
        homeNavGraph(onStartDetail = { navigator.navigationDetail(it) })
        detailNavGraph(onBackEvent = navigator::popBackStackIfNotHome)
    }
}