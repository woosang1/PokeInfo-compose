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
import com.example.detail.about.toAboutModel
import com.example.detail.baseStats.navigationBaseStats
import com.example.detail.baseStats.toBaseStatsModel
import com.example.detail.evolution.navigationEvolution
import com.example.detail.evolution.toEvolutionModel
import com.example.detail.moves.navigationMoves
import com.example.model.ui.Pokemon


class DetailNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    fun navigate(tab: DetailTabRouteModel, pokemon: Pokemon) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            is DetailTabRouteModel.About -> navController.navigationAbout(
                model = pokemon.toAboutModel(),
                navOptions = navOptions
            )
            is DetailTabRouteModel.BaseStats -> navController.navigationBaseStats(
                model = pokemon.toBaseStatsModel(),
                navOptions = navOptions
            )
            is DetailTabRouteModel.Evolution -> navController.navigationEvolution(
                model = pokemon.toEvolutionModel(),
                navOptions = navOptions
            )
            is DetailTabRouteModel.Moves -> navController.navigationMoves(navOptions)
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
