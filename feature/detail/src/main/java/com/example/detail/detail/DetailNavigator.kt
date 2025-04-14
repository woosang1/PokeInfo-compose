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
import com.example.detail.about.navigationAbout
import com.example.detail.about.toAboutModel
import com.example.detail.baseStats.navigationBaseStats
import com.example.detail.baseStats.toBaseStatsModel
import com.example.detail.evolution.navigationEvolution
import com.example.detail.evolution.toEvolutionModel
import com.example.detail.moves.navigationMoves
import com.example.log.DebugLog
import com.example.model.ui.Pokemon
import com.example.navigation.DetailTabRoute
import com.example.navigation.MainRoute


class DetailNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = DetailTabRoute.About

    fun navigate(tab: DetailTabRoute, pokemon: Pokemon) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            is DetailTabRoute.About -> navController.navigationAbout(
                model = pokemon.toAboutModel(),
                navOptions = navOptions
            )
            is DetailTabRoute.BaseStats -> navController.navigationBaseStats(
                model = pokemon.toBaseStatsModel(),
                navOptions = navOptions
            )
            is DetailTabRoute.Evolution -> navController.navigationEvolution(
                model = pokemon.toEvolutionModel(),
                navOptions = navOptions
            )
            is DetailTabRoute.Moves -> navController.navigationMoves(navOptions)
        }
    }

    fun backEvent(
        currentTab: DetailTabRoute,
        onTabChanged: (DetailTabRoute) -> Unit,
        onFirstTabAction: () -> Unit
    ) {
        DebugLog("--------------")
        DebugLog("DetailNavigatory - backEvent")
        DebugLog("currentTab : ${currentTab}")
        val currentIndex = DetailTabRoute.tabList.indexOfFirst { it::class == currentTab::class }
        DebugLog("currentIndex : ${currentIndex}")
        if (currentIndex > 0) {
            onTabChanged(DetailTabRoute.tabList[currentIndex - 1])
        } else {
            onFirstTabAction()
        }
        DebugLog("--------------")
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
