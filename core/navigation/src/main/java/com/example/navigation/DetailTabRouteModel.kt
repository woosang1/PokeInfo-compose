package com.example.navigation

sealed class DetailTabRouteModel(val title: String) {

    data object About : DetailTabRouteModel("정보")

    data object BaseStats : DetailTabRouteModel("상태")

    data object Evolution : DetailTabRouteModel("진화")

    data object Moves : DetailTabRouteModel("영상")

    companion object {
        val tabList: List<DetailTabRouteModel> = listOf(
            About, BaseStats, Evolution, Moves
        )
    }
}