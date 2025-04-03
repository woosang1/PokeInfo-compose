package com.example.model.ui

data class Pokemon(
    val id: Int = 0,
    val name: String = "",
    val url: String = "",
    val weight: Int = 0,
    val height: Int = 0,
    val count: Int = 0,
    val baseExperience: Int = 0,
    val abilities: List<String> = emptyList(),
    val stats: Map<String, Int> = emptyMap(),  // 스탯 이름과 값의 매핑
    val types: List<String> = emptyList(),      // 타입 목록
    val pokemonType: PokemonType? = null
)

fun getImageUrl(url: String): String {
    val id = getId(url)
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
            "pokemon/other/official-artwork/$id.png"
}
//fun name(name: String): String = name.replaceFirstChar { it.uppercase() }
fun getId(url: String): String = url.split("/".toRegex()).dropLast(1).last()
