package com.example.data.api.fake

import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonList
import com.example.model.rp.RpPokemonSpecies
import com.example.model.rp.RpPokemonType
import com.example.network.PokemonAPI

internal class FakePokemonAPI : PokemonAPI {

    override suspend fun getPokemonList(limit: Int, offset: Int): RpPokemonList {
        return RpPokemonList(
            count = 2,
            next = null,
            previous = null,
            results = listOf(
                RpPokemonList.Pokemon(
                    name = "bulbasaur",
                    url = "https://pokeapi.co/api/v2/pokemon/1/"
                ),
                RpPokemonList.Pokemon(
                    name = "pikachu",
                    url = "https://pokeapi.co/api/v2/pokemon/25/"
                )
            )
        )
    }

    override suspend fun getPokemonInfo(id: Int): RpPokemonInfo {
        return when (id) {
            1 -> RpPokemonInfo(
                id = 1,
                name = "피카츄",
                baseExperience = 112,
                height = 4,
                weight = 60,
                abilities = listOf(
                    RpPokemonInfo.Ability(ability = RpPokemonInfo.Ability.Ability(name = "static", url = "https://pokeapi.co/api/v2/ability/9/"), isHidden = false, slot = 1)
                ),
                moves = listOf(
                    RpPokemonInfo.Move(move = RpPokemonInfo.Move.Move(name = "quick-attack", url = "https://pokeapi.co/api/v2/move/57/"), versionGroupDetails = listOf())
                ),
                species = RpPokemonInfo.Species(name = "Pikachu", url = "https://pokeapi.co/api/v2/pokemon-species/25/"),
                sprites = null,
                cries = null,
                forms = null,
                gameIndices = null,
                heldItems = null,
                isDefault = null,
                locationAreaEncounters = null,
                order = null,
                pastAbilities = null,
                pastTypes = null,
                stats = null,
                types = null
            )
            2 -> RpPokemonInfo(
                id = 2,
                name = "이상해씨",
                baseExperience = 64,
                height = 7,
                weight = 69,
                abilities = listOf(
                    RpPokemonInfo.Ability(ability = RpPokemonInfo.Ability.Ability(name = "overgrow", url = "https://pokeapi.co/api/v2/ability/65/"), isHidden = false, slot = 1)
                ),
                moves = listOf(
                    RpPokemonInfo.Move(move = RpPokemonInfo.Move.Move(name = "tackle", url = "https://pokeapi.co/api/v2/move/33/"), versionGroupDetails = listOf())
                ),
                species = RpPokemonInfo.Species(name = "Bulbasaur", url = "https://pokeapi.co/api/v2/pokemon-species/1/"),
                sprites = null,
                cries = null,
                forms = null,
                gameIndices = null,
                heldItems = null,
                isDefault = null,
                locationAreaEncounters = null,
                order = null,
                pastAbilities = null,
                pastTypes = null,
                stats = null,
                types = null
            )
            else -> throw IllegalArgumentException("Unknown Pokemon ID")
        }
    }

    override suspend fun getPokemonSpeciesInfo(id: Int): RpPokemonSpecies {
        return when (id) {
            1 -> RpPokemonSpecies(
                id = 1,
                name = "피카츄",
                order = 1,
                genderRate = 4,
                captureRate = 190,
                baseHappiness = 70,
                isBaby = false,
                isLegendary = false,
                isMythical = false,
                hatchCounter = 10,
                hasGenderDifferences = true,
                formsSwitchable = false,
                growthRate = RpPokemonSpecies.NamedApiResource(name = "medium-fast", url = "https://pokeapi.co/api/v2/growth-rate/4/"),
                pokedexNumbers = listOf(
                    RpPokemonSpecies.PokedexNumber(entryNumber = 25, pokedex = RpPokemonSpecies.NamedApiResource(name = "national", url = "https://pokeapi.co/api/v2/pokedex/1/"))
                ),
                eggGroups = listOf(
                    RpPokemonSpecies.NamedApiResource(name = "field", url = "https://pokeapi.co/api/v2/egg-group/1/"),
                    RpPokemonSpecies.NamedApiResource(name = "fairy", url = "https://pokeapi.co/api/v2/egg-group/2/")
                ),
                color = RpPokemonSpecies.NamedApiResource(name = "yellow", url = "https://pokeapi.co/api/v2/color/1/"),
                shape = RpPokemonSpecies.NamedApiResource(name = "quadruped", url = "https://pokeapi.co/api/v2/pokemon-shape/4/"),
                evolvesFromSpecies = null,
                evolutionChain = RpPokemonSpecies.EvolutionChain(url = "https://pokeapi.co/api/v2/evolution-chain/12/"),
                habitat = RpPokemonSpecies.NamedApiResource(name = "forest", url = "https://pokeapi.co/api/v2/pokemon-habitat/3/"),
                generation = RpPokemonSpecies.NamedApiResource(name = "generation-i", url = "https://pokeapi.co/api/v2/generation/1/"),
                names = listOf(
                    RpPokemonSpecies.LocalizedName(name = "Pikachu", language = RpPokemonSpecies.NamedApiResource(name = "en", url = "https://pokeapi.co/api/v2/language/9/")),
                    RpPokemonSpecies.LocalizedName(name = "ピカチュウ", language = RpPokemonSpecies.NamedApiResource(name = "ja", url = "https://pokeapi.co/api/v2/language/1/"))
                ),
                flavorTextEntries = listOf(
                    RpPokemonSpecies.FlavorTextEntry(
                        flavorText = "Pikachu, an Electric-type Pokémon, is known for its high-pitched voice and powerful electrical discharges.",
                        language = RpPokemonSpecies.NamedApiResource(name = "en", url = "https://pokeapi.co/api/v2/language/9/"),
                        version = RpPokemonSpecies.NamedApiResource(name = "red-blue", url = "https://pokeapi.co/api/v2/version/1/")
                    )
                ),
                formDescriptions = listOf(),
                genera = listOf(
                    RpPokemonSpecies.Genus(genus = "Mouse Pokémon", language = RpPokemonSpecies.NamedApiResource(name = "en", url = "https://pokeapi.co/api/v2/language/9/"))
                ),
                varieties = listOf(
                    RpPokemonSpecies.Variety(isDefault = true, pokemon = RpPokemonSpecies.NamedApiResource(name = "pikachu", url = "https://pokeapi.co/api/v2/pokemon/25/"))
                )
            )
            2 -> RpPokemonSpecies(
                id = 2,
                name = "이상해씨",
                order = 2,
                genderRate = 4,
                captureRate = 45,
                baseHappiness = 70,
                isBaby = false,
                isLegendary = false,
                isMythical = false,
                hatchCounter = 20,
                hasGenderDifferences = true,
                formsSwitchable = false,
                growthRate = RpPokemonSpecies.NamedApiResource(name = "medium-slow", url = "https://pokeapi.co/api/v2/growth-rate/3/"),
                pokedexNumbers = listOf(
                    RpPokemonSpecies.PokedexNumber(entryNumber = 1, pokedex = RpPokemonSpecies.NamedApiResource(name = "national", url = "https://pokeapi.co/api/v2/pokedex/1/"))
                ),
                eggGroups = listOf(
                    RpPokemonSpecies.NamedApiResource(name = "monster", url = "https://pokeapi.co/api/v2/egg-group/1/"),
                    RpPokemonSpecies.NamedApiResource(name = "plant", url = "https://pokeapi.co/api/v2/egg-group/5/")
                ),
                color = RpPokemonSpecies.NamedApiResource(name = "green", url = "https://pokeapi.co/api/v2/color/4/"),
                shape = RpPokemonSpecies.NamedApiResource(name = "quadruped", url = "https://pokeapi.co/api/v2/pokemon-shape/4/"),
                evolvesFromSpecies = null,
                evolutionChain = RpPokemonSpecies.EvolutionChain(url = "https://pokeapi.co/api/v2/evolution-chain/2/"),
                habitat = RpPokemonSpecies.NamedApiResource(name = "grassland", url = "https://pokeapi.co/api/v2/pokemon-habitat/2/"),
                generation = RpPokemonSpecies.NamedApiResource(name = "generation-i", url = "https://pokeapi.co/api/v2/generation/1/"),
                names = listOf(
                    RpPokemonSpecies.LocalizedName(name = "Bulbasaur", language = RpPokemonSpecies.NamedApiResource(name = "en", url = "https://pokeapi.co/api/v2/language/9/")),
                    RpPokemonSpecies.LocalizedName(name = "フシギダネ", language = RpPokemonSpecies.NamedApiResource(name = "ja", url = "https://pokeapi.co/api/v2/language/1/"))
                ),
                flavorTextEntries = listOf(
                    RpPokemonSpecies.FlavorTextEntry(
                        flavorText = "Bulbasaur, a Grass/Poison-type Pokémon, is known for the plant on its back that grows as it evolves.",
                        language = RpPokemonSpecies.NamedApiResource(name = "en", url = "https://pokeapi.co/api/v2/language/9/"),
                        version = RpPokemonSpecies.NamedApiResource(name = "red-blue", url = "https://pokeapi.co/api/v2/version/1/")
                    )
                ),
                formDescriptions = listOf(),
                genera = listOf(
                    RpPokemonSpecies.Genus(genus = "Seed Pokémon", language = RpPokemonSpecies.NamedApiResource(name = "en", url = "https://pokeapi.co/api/v2/language/9/"))
                ),
                varieties = listOf(
                    RpPokemonSpecies.Variety(isDefault = true, pokemon = RpPokemonSpecies.NamedApiResource(name = "bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"))
                )
            )
            else -> throw IllegalArgumentException("Unknown Pokemon ID")
        }
    }

    override suspend fun getPokemonTypeInfo(type: String): RpPokemonType {
        return when (type) {
            "electric" -> RpPokemonType(name = "electric", damageRelations = null)
            "grass" -> RpPokemonType(name = "grass", damageRelations = null)
            else -> throw IllegalArgumentException("Unknown type")
        }
    }
}