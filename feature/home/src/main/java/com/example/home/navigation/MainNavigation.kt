package com.example.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.home.HomeRoute
import com.example.navigation.Route

fun NavController.navigationHome(){
    navigate(Route.Home)
}

fun NavGraphBuilder.homeNavGraph(
    onNavigateDetail : () -> Unit,
) {
    composable<Route.Home>{
        HomeRoute(
            onNavigateDetail = onNavigateDetail
        )
    }
}