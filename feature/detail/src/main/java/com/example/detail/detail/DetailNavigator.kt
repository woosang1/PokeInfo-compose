package com.example.detail.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.navigation.DetailTabRouteModel
import com.example.navigation.MainRoute
import com.example.detail.about.navigationAbout
import com.example.detail.baseStats.navigationBaseStats
import com.example.detail.evolution.navigationEvolution
import com.example.detail.moves.navigationMoves


class DetailNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    fun navigate(tab: DetailTabRouteModel) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            DetailTabRouteModel.About -> navController.navigationAbout(navOptions)
            DetailTabRouteModel.BaseStats -> navController.navigationBaseStats(navOptions)
            DetailTabRouteModel.Evolution -> navController.navigationEvolution(navOptions)
            DetailTabRouteModel.Moves -> navController.navigationMoves(navOptions)
        }
    }

    private inline fun <reified T : MainRoute> isSameCurrentDestination(): Boolean {
        return navController.currentDestination?.hasRoute<T>() == true
    }

}

@Composable
internal fun rememberDetailNavigator(
    navController: NavHostController = rememberNavController(),
): DetailNavigator = remember(navController) {
    DetailNavigator(navController)
}
