package com.example.database.room

import com.example.model.ui.Pokemon

fun Pokemon.toEntity(): PokemonRoomEntity = PokemonRoomEntity(
    id = id,
    name = name,
    url = url,
    weight = weight,
    height = height,
    count = count,
    color = color,
    isLike = isLike,
    baseExperience = baseExperience,
    abilities = abilities,
    stats = stats,
    types = types,
    pokemonType = pokemonType,
    description = description,
    genderRate = genderRate,
    eggGroups = eggGroups,
    eggCycle = eggCycle
)


fun PokemonRoomEntity.toDomain(): Pokemon = Pokemon(
    id = id,
    name = name,
    url = url,
    weight = weight,
    height = height,
    count = count,
    color = color,
    isLike = isLike,
    baseExperience = baseExperience,
    abilities = abilities,
    stats = stats,
    types = types,
    pokemonType = pokemonType,
    description = description,
    genderRate = genderRate,
    eggGroups = eggGroups,
    eggCycle = eggCycle
)