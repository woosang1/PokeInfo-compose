package com.example.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
//    val routeType: RouteType

    @Serializable
    data object Home : Route
//    data class Home(override val routeType: RouteType = RouteType.HOME) : Route

    @Serializable
    data object Detail: Route

//    @Serializable
//    data object Detail(
////        override val routeType: RouteType = RouteType.DETAIL,
////        val pk: String
//    ) : Route
}

enum class RouteType(val description: String) {
    HOME(description = "홈"),
    DETAIL(description = "상세")
}