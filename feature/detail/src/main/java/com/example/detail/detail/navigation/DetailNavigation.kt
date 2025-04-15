package com.example.detail.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.detail.detail.DetailRoute
import com.example.navigation.MainRoute

fun NavController.navigationDetail(pk: String){
    navigate(MainRoute.Detail(pk = pk))
}

fun NavGraphBuilder.detailNavGraph(
    onBackEvent : () -> Unit,
    onHandleNetworkUI: (throwable: Throwable?) -> Unit
) {
    composable<MainRoute.Detail> { navBackStackEntry ->
        val pk = navBackStackEntry.toRoute<MainRoute.Detail>().pk
        DetailRoute(
            pk = pk,
            onBackEvent = onBackEvent,
            onHandleNetworkUI = onHandleNetworkUI
        )
    }
}