package com.example.detail.about

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigation.DetailTabRouteModel

fun NavController.navigationAbout(navOptions: NavOptions){
    navigate(DetailTabRouteModel.About, navOptions)
}

fun NavGraphBuilder.aboutNavGraph() {
    composable<DetailTabRouteModel.About>{
        AboutRoute()
    }
}