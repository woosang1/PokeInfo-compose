package com.example.detail.detail.common

import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonType

// "Water" 타입을 정의하는 객체
val waterType = PokemonType.Type(name = "Water", url = "https://pokeapi.co/api/v2/type/11/")

// 거북왕(Blastoise)의 더미 데이터(Mock Data) 정의
val mockBlastoise = Pokemon(
    id = 9,  // 포켓몬 ID (전국 도감 기준)
    name = "Blastoise",  // 포켓몬 이름
    url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/9.png",  // 포켓몬  URL
    weight = 855,  // 무게 (85.5kg, 단위: hectograms)
    height = 16,  // 키 (1.6m, 단위: decimeters)
    count = 1,  // 소유 개수 (사용자 데이터 관리 용도)
    baseExperience = 265,  // 격파 시 얻는 기본 경험치

    // 포켓몬이 가진 능력 (특성 & 숨겨진 특성 포함)
    abilities = listOf("Torrent", "Rain Dish"),

    // 포켓몬의 기본 능력치 (Base Stats)
    stats = mapOf(
        "hp" to 79,  // 체력 (HP)
        "attack" to 83,  // 공격력 (Attack)
        "defense" to 100,  // 방어력 (Defense)
        "special-attack" to 85,  // 특수 공격력 (Special Attack)
        "special-defense" to 105,  // 특수 방어력 (Special Defense)
        "speed" to 78  // 스피드 (Speed)
    ),

    // 포켓몬이 가지는 타입 (Blastoise는 "Water" 타입)
    types = listOf(waterType.name!!),

    // 포켓몬 타입 관련 정보 (상성 및 피해 관계)
    pokemonType = PokemonType(
        name = waterType.name,  // 포켓몬 타입 이름 ("Water")

        damageRelations = PokemonType.DamageRelations(
            // 2배 피해를 받는 타입 (Water 타입이 약한 속성)
            doubleDamageFrom = listOf(
                PokemonType.Type(name = "Electric", url = "https://pokeapi.co/api/v2/type/13/"),
                PokemonType.Type(name = "Grass", url = "https://pokeapi.co/api/v2/type/12/")
            ),

            // 2배 피해를 주는 타입 (Water 타입이 강한 속성)
            doubleDamageTo = listOf(
                PokemonType.Type(name = "Fire", url = "https://pokeapi.co/api/v2/type/10/"),
                PokemonType.Type(name = "Ground", url = "https://pokeapi.co/api/v2/type/5/"),
                PokemonType.Type(name = "Rock", url = "https://pokeapi.co/api/v2/type/6/")
            ),

            // 0.5배 피해를 받는 타입 (Water 타입이 저항하는 속성)
            halfDamageFrom = listOf(
                PokemonType.Type(name = "Steel", url = "https://pokeapi.co/api/v2/type/9/"),
                PokemonType.Type(name = "Fire", url = "https://pokeapi.co/api/v2/type/10/"),
                PokemonType.Type(name = "Water", url = "https://pokeapi.co/api/v2/type/11/"),
                PokemonType.Type(name = "Ice", url = "https://pokeapi.co/api/v2/type/15/")
            ),

            // 0.5배 피해를 주는 타입 (Water 타입이 약한 공격 속성)
            halfDamageTo = listOf(
                PokemonType.Type(name = "Water", url = "https://pokeapi.co/api/v2/type/11/"),
                PokemonType.Type(name = "Grass", url = "https://pokeapi.co/api/v2/type/12/"),
                PokemonType.Type(name = "Dragon", url = "https://pokeapi.co/api/v2/type/16/")
            ),

            // 무효화하는 피해 (Water 타입이 데미지를 받지 않는 속성)
            noDamageFrom = emptyList(),

            // 무효화하는 공격 (Water 타입이 피해를 줄 수 없는 속성)
            noDamageTo = emptyList()
        )
    ),
    description = "Blastoise는 강력한 물대포를 사용할 수 있는 포켓몬이다.",
    genderRate = Pair(87.5, 12.5), // 성비 (수컷 87.5%, 암컷 12.5%)
    eggGroups = "Monster, Water 1", // 알 그룹 정보
    eggCycle = 20 // 부화 사이클
)
