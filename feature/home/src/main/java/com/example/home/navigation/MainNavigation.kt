package com.example.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.home.HomeRoute
import com.example.navigation.MainRoute

fun NavGraphBuilder.homeNavGraph(
    onStartDetail : (String) -> Unit
) {
    composable<MainRoute.Home>{
        HomeRoute(onClickItem = onStartDetail)
    }
}