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
    // TODO: id값 넘겨야아함. 
    composable<Route.Detail>{
        DetailRoute(
            onStartHome = onNavigateHome
        )
    }
}