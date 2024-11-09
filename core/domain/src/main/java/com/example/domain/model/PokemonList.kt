package com.example.domain.model

data class PokemonList(
    val count: Int = 0,
    val next: String = "",
    val previous: String = "",
    val results: List<Pokemon> = emptyList(),
) {

    data class Pokemon(
        val id: Int = 0,
        val count: Int = 0,
        val name: String = "",
        val url: String = "",
    )
}

fun getImageUrl(url: String): String {
    val id = getId(url)
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
            "pokemon/other/official-artwork/$id.png"
}
//fun name(name: String): String = name.replaceFirstChar { it.uppercase() }
fun getId(url: String): String = url.split("/".toRegex()).dropLast(1).last()


