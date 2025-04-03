package com.example.detail.baseStats

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.model.ui.BaseStatsModel
import com.example.navigation.DetailTabRouteModel
import kotlinx.serialization.json.Json

fun NavController.navigationBaseStats(model: BaseStatsModel, navOptions: NavOptions){
    navigate(
        DetailTabRouteModel.BaseStats(modelJsonStr = Json.encodeToString(model)), navOptions
    )
}

fun NavGraphBuilder.baseStatsNavGraph() {
    composable<DetailTabRouteModel.BaseStats> { navBackStackEntry ->
        val modelJsonStr = navBackStackEntry.toRoute<DetailTabRouteModel.BaseStats>().modelJsonStr
        val model = try {
            if (!modelJsonStr.isNullOrBlank()) {
                Json.decodeFromString<BaseStatsModel>(modelJsonStr)
            } else null
        } catch (e: Exception) {
            null // 에러 발생 시 null 반환
        }
        BaseStatsRoute(model = model)
    }
}