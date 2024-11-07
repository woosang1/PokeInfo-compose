package com.example.data.mapper

import android.util.Log
import com.example.data.model.rp.RpPokemonInfo
import com.example.domain.model.PokemonInfo

fun List<RpPokemonInfo.RpPokemonItem>.mapperToPokemonInfo(): List<PokemonInfo> {
    return ArrayList<PokemonInfo>().apply {
        this@mapperToPokemonInfo.forEachIndexed { index, result ->
            add(
                PokemonInfo(
                    id = result.id ?: "",
                    name = result.name ?: "",
                    image = result.imageUrl ?: "",
                    type = result.typeOfPokemon ?: ArrayList<String>().toList(),
                    abilities = result.abilities ?: ArrayList<String?>().toList(),
                    attack = result.attack ?: 0,
                    baseExp = result.baseExp ?: "",
                    category = result.category ?: "",
                    cycles = result.cycles ?: "",
                    defense = result.defense ?: 0,
                    eggGroups = result.eggGroups ?: "",
                    evolutions = getPokemonByEvolutionId(result.evolutions),
                    evolvedfrom = result.evolvedFrom ?: "",
                    femalePercentage = result.femalePercentage ?: "",
                    genderless = result.genderless ?: 0,
                    height = result.height ?: "",
                    hp = result.hp ?: 0,
                    malePercentage = result.malePercentage ?: "",
                    reason = result.reason ?: "",
                    specialAttack = result.specialAttack ?: 0,
                    specialDefense = result.specialDefense ?: 0,
                    speed = result.speed ?: 0,
                    total = result.total ?: 0,
                    typeofpokemon = result.typeOfPokemon ?: ArrayList<String>().toList(),
                    weaknesses = result.weaknesses ?: ArrayList<String?>().toList(),
                    weight = result.weight ?: "",
                    xdescription = result.xDescription ?: "",
                    ydescription = result.yDescription ?: ""
                )
            )
        }
    }
}

internal fun List<RpPokemonInfo.RpPokemonItem>.getPokemonByEvolutionId(idList : List<String?>?) : List<PokemonInfo> {
    val evolutions = ArrayList<PokemonInfo>()
    idList?.forEachIndexed { index, id ->
        val evolutionPokemon = this.firstOrNull { it.id == id }
        evolutionPokemon?.let { it ->
            evolutions.add(
                PokemonInfo(
                id = it.id ?: "",
                name = it.name ?: "",
                image = it.imageUrl ?: "",
                type = it.typeOfPokemon ?: ArrayList<String>().toList(),
                abilities = it.abilities ?: ArrayList<String?>().toList(),
                attack = it.attack ?: 0,
                baseExp = it.baseExp ?: "",
                category = it.category ?: "",
                cycles = it.cycles ?: "",
                defense = it.defense ?: 0,
                eggGroups = it.eggGroups ?: "",
                evolutions = null,
                evolvedfrom = it.evolvedFrom ?: "",
                femalePercentage = it.femalePercentage ?: "",
                genderless = it.genderless ?: 0,
                height = it.height ?: "",
                hp = it.hp ?: 0,
                malePercentage = it.malePercentage ?: "",
                reason = it.reason ?: "",
                specialAttack = it.specialAttack ?: 0,
                specialDefense = it.specialDefense ?: 0,
                speed = it.speed ?: 0,
                total = it.total ?: 0,
                typeofpokemon = it.typeOfPokemon ?: ArrayList<String>().toList(),
                weaknesses = it.weaknesses ?: ArrayList<String?>().toList(),
                weight = it.weight ?: "",
                xdescription = it.xDescription ?: "",
                ydescription = it.yDescription ?: ""
            )
            )
        }
    }
    Log.i("logger" , "evolutions.toList()")
    return evolutions.toList()
}