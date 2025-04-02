package com.example.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.detail.DetailRoute
import com.example.navigation.Route

fun NavController.navigationDetail(pk: String){
    navigate(Route.Detail(pk = pk))
}

fun NavGraphBuilder.detailNavGraph(
    onNavigateHome : () -> Unit
) {
    composable<Route.Detail> { navBackStackEntry ->
        val pk = navBackStackEntry.toRoute<Route.Detail>().pk
        DetailRoute(
            pk = pk,
            onStartHome = onNavigateHome
        )
    }
}