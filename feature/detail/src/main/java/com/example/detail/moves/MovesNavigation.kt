package com.example.detail.moves

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigation.DetailTabRoute

fun NavController.navigationMoves(navOptions: NavOptions){
    navigate(DetailTabRoute.Moves, navOptions)
}

fun NavGraphBuilder.movesNavGraph() {
    composable<DetailTabRoute.Moves>{
        MovesRoute()
    }
}