package com.example.data.model.rp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RpPokemonList(
    @SerialName("count")
    val count: Int?,
    @SerialName("next")
    val next: String?,
    @SerialName("previous")
    val previous: String?,
    @SerialName("results")
    val results: List<Pokemon>,
) {

    @Serializable
    data class Pokemon(
        @SerialName("count")
        val count: Int = 0,
        @SerialName("name")
        val name: String,
        @SerialName("url")
        val url: String,
    )
}

