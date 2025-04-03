package com.example.detail.baseStats

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigation.DetailTabRouteModel

fun NavController.navigationBaseStats(navOptions: NavOptions){
    navigate(DetailTabRouteModel.BaseStats, navOptions)
}

fun NavGraphBuilder.baseStatsNavGraph() {
    composable<DetailTabRouteModel.BaseStats>{
        AboutRoute()
    }
}