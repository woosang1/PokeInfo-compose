package com.example.detail.about

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.model.ui.AboutModel
import com.example.navigation.DetailTabRoute
import com.example.utils.log.DebugLog
import kotlinx.serialization.json.Json

fun NavController.navigationAbout(model: AboutModel, navOptions: NavOptions) {
    navigate(
        DetailTabRoute.About(modelJsonStr = Json.encodeToString(model)), navOptions
    )
}

fun NavGraphBuilder.aboutNavGraph() {
    composable<DetailTabRoute.About> { navBackStackEntry ->
        DebugLog("NavGraphBuilder.aboutNavGraph()")
        val modelJsonStr = navBackStackEntry.toRoute<DetailTabRoute.About>().modelJsonStr
        DebugLog("modelJsonStr : ${modelJsonStr}")
        val model = try {
            if (!modelJsonStr.isNullOrBlank()) {
                Json.decodeFromString<AboutModel>(modelJsonStr)
            } else null
        } catch (e: Exception) {
            null // 에러 발생 시 null 반환
        }
        AboutRoute(model = model)
    }
}