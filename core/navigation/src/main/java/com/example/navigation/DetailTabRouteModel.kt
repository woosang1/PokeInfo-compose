package com.example.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class DetailTabRouteModel(val title: String) {

    @Serializable
    data object About : DetailTabRouteModel("정보")

    @Serializable
    data object BaseStats : DetailTabRouteModel("상태")

    @Serializable
    data object Evolution : DetailTabRouteModel("진화")

    @Serializable
    data object Moves : DetailTabRouteModel("영상")

    companion object {
        val tabList: List<DetailTabRouteModel> = listOf(
            About, BaseStats, Evolution, Moves
        )
    }
}
