package com.example.navigation
//import kotlinx.serialization.Serializable

sealed interface Route {

    data object Main : Route
    data class Detail(val pk: String) : Route
}