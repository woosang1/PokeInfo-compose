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
    val stats: Stats = Stats(),  // 스탯 이름과 값의 매핑
    val types: List<String> = emptyList(),      // 타입 목록
    val pokemonType: PokemonType? = null,
    val description: String,
    val genderRate: Pair<Double, Double>, // (성비)
    val eggGroups: String, //  (알 그룹)
    val eggCycle: Int //  (부화 사이클)
) {
    data class Stats(
        val hp: Int = 0,
        val attack: Int = 0,
        val defense: Int = 0,
        val specialAttack: Int = 0,
        val specialDefense: Int = 0,
        val speed: Int = 0
    ) {
        val total: Int
            get() = hp + attack + defense + specialAttack + specialDefense + speed
    }
}

fun getImageUrl(url: String): String {
    val id = getId(url)
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
            "pokemon/other/official-artwork/$id.png"
}
//fun name(name: String): String = name.replaceFirstChar { it.uppercase() }
fun getId(url: String): String = url.split("/".toRegex()).dropLast(1).last()
