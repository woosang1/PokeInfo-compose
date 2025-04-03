package com.example.detail.evolution

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.model.ui.BaseStatsModel
import com.example.model.ui.EvolutionModel
import com.example.navigation.DetailTabRouteModel
import kotlinx.serialization.json.Json

fun NavController.navigationEvolution(model: EvolutionModel, navOptions: NavOptions){
    navigate(
        DetailTabRouteModel.Evolution(modelJsonStr = Json.encodeToString(model)), navOptions
    )}

fun NavGraphBuilder.evolutionNavGraph() {
    composable<DetailTabRouteModel.Evolution>{ navBackStackEntry ->
        val modelJsonStr = navBackStackEntry.toRoute<DetailTabRouteModel.Evolution>().modelJsonStr
        val model = try {
            if (!modelJsonStr.isNullOrBlank()) {
                Json.decodeFromString<EvolutionModel>(modelJsonStr)
            } else null
        } catch (e: Exception) {
            null // 에러 발생 시 null 반환
        }
        EvolutionRoute(model = model)
    }
}