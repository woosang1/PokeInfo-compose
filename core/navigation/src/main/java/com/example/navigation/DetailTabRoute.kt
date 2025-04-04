package com.example.navigation

import kotlinx.serialization.Serializable

sealed interface DetailTabRoute {
    val title: String

    @Serializable
    data class About(val modelJsonStr: String? = null) : DetailTabRoute {
        override val title: String = "정보"
    }

    @Serializable
    data class BaseStats(val modelJsonStr: String? = null) : DetailTabRoute {
        override val title: String = "상태"
    }

    @Serializable
    data class Evolution(val modelJsonStr: String? = null) : DetailTabRoute {
        override val title: String = "진화"
    }

    @Serializable
    data object Moves : DetailTabRoute {
        override val title: String = "영상"
    }

    companion object {
        val tabList: List<DetailTabRoute> = listOf(
            About(), BaseStats(), Evolution(), Moves
        )

        fun DetailTabRoute.getIndex(): Int {
            return tabList.indexOfFirst { it::class == this::class }
        }
    }
}