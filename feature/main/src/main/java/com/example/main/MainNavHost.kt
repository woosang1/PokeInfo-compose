package com.example.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.detail.detail.navigation.detailNavGraph
import com.example.home.navigation.homeNavGraph
import com.example.navigation.MainRoute


@Composable
internal fun MainNavHost(
    navigator: MainNavigator = rememberMainNavigator(),
    onHandleNetworkUI: (throwable: Throwable?) -> Unit
) {
    NavHost(
        navController = navigator.navController,
        startDestination = MainRoute.Home
    ) {
        homeNavGraph(
            onStartDetail = { navigator.navigationDetail(it) },
            onHandleNetworkUI = onHandleNetworkUI
        )
        detailNavGraph(
            onBackEvent = navigator::popBackStackIfNotHome,
            onHandleNetworkUI = onHandleNetworkUI
        )
    }
}