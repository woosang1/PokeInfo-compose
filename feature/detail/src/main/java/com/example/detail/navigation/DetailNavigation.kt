package com.example.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.detail.DetailRoute
import com.example.navigation.Route

fun NavController.navigationDetail(){
    navigate(Route.Detail)
}

fun NavGraphBuilder.detailNavGraph(
    onNavigateHome : () -> Unit
) {
    composable<Route.Detail>{
        DetailRoute(
            onStartHome = onNavigateHome
        )
    }
}