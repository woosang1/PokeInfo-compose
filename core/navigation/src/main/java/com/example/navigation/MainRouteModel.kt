package com.example.navigation

import kotlinx.serialization.Serializable

sealed interface MainRoute {

    @Serializable
    data object Home : MainRoute

    @Serializable
    data class Detail(val pk: String) : MainRoute
}
