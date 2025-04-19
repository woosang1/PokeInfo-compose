package com.example.data.mapper

import com.example.model.rp.RpPokemonInfo
import com.example.model.ui.Pokemon
import com.example.model.ui.getImageUrl
import com.example.model.ui.getSpriteImageUrl
import com.example.model.ui.getSpritesShinyImageUrl

fun RpPokemonInfo.toEntity(): Pokemon {
    val id = id ?: 0
    return Pokemon(
        id = id,
        name = name.orEmpty(),
        thumbnailUrl = getImageUrl(id.toString()),
        spriteImageUrl = getSpriteImageUrl(id.toString()),
        spritesShinyImageUrl = getSpritesShinyImageUrl(id.toString()),
        weight = weight ?: 0,
        height = height ?: 0,
        baseExperience = baseExperience ?: 0,

        // 능력치 이름만 추출
        abilities = abilities?.map { it?.ability?.name.orEmpty() } ?: emptyList(),

        // 스탯은 이름으로 구분하여 각각 매핑
        stats = Pokemon.Stats(
            hp = getStatValue("hp"),
            attack = getStatValue("attack"),
            defense = getStatValue("defense"),
            specialAttack = getStatValue("special-attack"),
            specialDefense = getStatValue("special-defense"),
            speed = getStatValue("speed")
        ),

        // 타입 이름만 추출
        types = types?.map { it?.type?.name.orEmpty() } ?: emptyList(),
    )
}

// 주어진 스탯 이름에 해당하는 값을 반환. 없으면 0 반환.
private fun RpPokemonInfo.getStatValue(statName: String): Int {
    return stats
        ?.firstOrNull { it?.stat?.name == statName }
        ?.baseStat ?: 0
}
