package com.example.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.detail.navigation.detailNavGraph
import com.example.detail.navigation.navigationDetail
import com.example.home.navigation.homeNavGraph
import com.example.home.navigation.navigationHome
import com.example.navigation.MainRoute


@Composable
internal fun MainNavHost(
    navigator: NavHostController
) {
    NavHost(
        navController = navigator,
        startDestination = MainRoute.Home
    ) {
        homeNavGraph(onStartDetail = { navigator.navigationDetail(it) })
        detailNavGraph(onNavigateHome = { navigator.navigationHome() })
    }
}