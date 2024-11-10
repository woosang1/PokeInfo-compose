package com.example.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.detail.navigation.detailNavGraph
import com.example.detail.navigation.navigationDetail
import com.example.home.navigation.homeNavGraph
import com.example.home.navigation.navigationHome
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
        homeNavGraph(onNavigateDetail = { navigator.navigationDetail() })
        detailNavGraph(onNavigateHome = { navigator.navigationHome() })
    }
}