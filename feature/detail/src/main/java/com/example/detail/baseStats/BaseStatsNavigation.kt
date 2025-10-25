package com.example.detail.baseStats

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.model.ui.BaseStatsModel
import com.example.navigation.DetailTabRoute
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString

fun NavController.navigationBaseStats(model: BaseStatsModel, navOptions: NavOptions){
    navigate(
        DetailTabRoute.BaseStats(modelJsonStr = Json.encodeToString<BaseStatsModel>(model)), navOptions
    )
}

fun NavGraphBuilder.baseStatsNavGraph() {
    composable<DetailTabRoute.BaseStats> { navBackStackEntry ->
        val modelJsonStr = navBackStackEntry.toRoute<DetailTabRoute.BaseStats>().modelJsonStr
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