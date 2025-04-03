package com.example.detail.moves

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigation.DetailTabRouteModel

fun NavController.navigationMoves(navOptions: NavOptions){
    navigate(DetailTabRouteModel.Moves, navOptions)
}

fun NavGraphBuilder.movesNavGraph() {
    composable<DetailTabRouteModel.Moves>{
        MovesRoute()
    }
}