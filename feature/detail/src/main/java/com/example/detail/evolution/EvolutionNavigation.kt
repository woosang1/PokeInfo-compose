package com.example.detail.evolution

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigation.DetailTabRouteModel

fun NavController.navigationEvolution(navOptions: NavOptions){
    navigate(DetailTabRouteModel.Evolution, navOptions)
}

fun NavGraphBuilder.evolutionNavGraph() {
    composable<DetailTabRouteModel.Evolution>{
        EvolutionRoute()
    }
}