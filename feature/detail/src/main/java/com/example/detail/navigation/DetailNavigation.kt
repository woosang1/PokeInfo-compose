package com.example.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.detail.DetailRoute

fun NavController.navigationDetail(pk: String){
    navigate(com.example.navigation.MainRoute.Detail(pk = pk))
}

fun NavGraphBuilder.detailNavGraph(
    onNavigateHome : () -> Unit
) {
    composable<com.example.navigation.MainRoute.Detail> { navBackStackEntry ->
        val pk = navBackStackEntry.toRoute<com.example.navigation.MainRoute.Detail>().pk
        DetailRoute(
            pk = pk,
            onStartHome = onNavigateHome
        )
    }
}