package com.example.detail.about

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.log.DebugLog
import com.example.model.ui.AboutModel
import com.example.navigation.DetailTabRouteModel
import kotlinx.serialization.json.Json

fun NavController.navigationAbout(model: AboutModel, navOptions: NavOptions) {
    navigate(
        DetailTabRouteModel.About(modelJsonStr = Json.encodeToString(model)), navOptions
    )
}

fun NavGraphBuilder.aboutNavGraph() {
    composable<DetailTabRouteModel.About> { navBackStackEntry ->
        val modelJsonStr = navBackStackEntry.toRoute<DetailTabRouteModel.About>().modelJsonStr
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