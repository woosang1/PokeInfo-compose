package com.example.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    val routeType: RouteType

    @Serializable
    data class Home(override val routeType: RouteType = RouteType.HOME) : Route

    @Serializable
    data class Detail(
        override val routeType: RouteType = RouteType.DETAIL,
        val pk: String
    ) : Route
}

enum class RouteType(val description: String) {
    HOME(description = "홈"),
    DETAIL(description = "상세")
}