package com.example.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.home.HomeRoute
import com.example.navigation.Route

fun NavController.navigationMain(){
    navigate(Route.Main)
}

fun NavGraphBuilder.homeNavGraph(
    onMainClick : (String) -> Unit,
) {
    composable<Route.Main>{
        HomeRoute()
    }
}