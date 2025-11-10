package com.example.detail.detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.detail.detail.DetailRoute
import com.example.navigation.MainRoute

fun NavGraphBuilder.detailNavGraph(
    onBackEvent : () -> Unit
) {
    composable<MainRoute.Detail> { navBackStackEntry ->
        val pk = navBackStackEntry.toRoute<MainRoute.Detail>().pk
        DetailRoute(
            pk = pk,
            onBackEvent = onBackEvent
        )
    }
}