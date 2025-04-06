package com.example.model.rp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RpPokemonSpecies(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("order") val order: Int,
    @SerialName("gender_rate") val genderRate: Int,
    @SerialName("capture_rate") val captureRate: Int,
    @SerialName("base_happiness") val baseHappiness: Int,
    @SerialName("is_baby") val isBaby: Boolean,
    @SerialName("is_legendary") val isLegendary: Boolean,
    @SerialName("is_mythical") val isMythical: Boolean,
    @SerialName("hatch_counter") val hatchCounter: Int,
    @SerialName("has_gender_differences") val hasGenderDifferences: Boolean,
    @SerialName("forms_switchable") val formsSwitchable: Boolean,
    @SerialName("growth_rate") val growthRate: NamedApiResource,
    @SerialName("pokedex_numbers") val pokedexNumbers: List<PokedexNumber>,
    @SerialName("egg_groups") val eggGroups: List<NamedApiResource>,
    @SerialName("color") val color: NamedApiResource,
    @SerialName("shape") val shape: NamedApiResource,
    @SerialName("evolves_from_species") val evolvesFromSpecies: NamedApiResource? = null,
    @SerialName("evolution_chain") val evolutionChain: EvolutionChain,
    @SerialName("habitat") val habitat: NamedApiResource? = null,
    @SerialName("generation") val generation: NamedApiResource,
    @SerialName("names") val names: List<LocalizedName>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
    @SerialName("form_descriptions") val formDescriptions: List<FormDescription>,
    @SerialName("genera") val genera: List<Genus>,
    @SerialName("varieties") val varieties: List<Variety>
) {
    @Serializable
    data class NamedApiResource(
        @SerialName("name") val name: String,
        @SerialName("url") val url: String
    )

    @Serializable
    data class PokedexNumber(
        @SerialName("entry_number") val entryNumber: Int,
        @SerialName("pokedex") val pokedex: NamedApiResource
    )

    @Serializable
    data class EvolutionChain(
        @SerialName("url") val url: String
    )

    @Serializable
    data class LocalizedName(
        @SerialName("name") val name: String,
        @SerialName("language") val language: NamedApiResource
    )

    @Serializable
    data class FlavorTextEntry(
        @SerialName("flavor_text") val flavorText: String,
        @SerialName("language") val language: NamedApiResource,
        @SerialName("version") val version: NamedApiResource
    )

    @Serializable
    data class FormDescription(
        @SerialName("description") val description: String,
        @SerialName("language") val language: NamedApiResource
    )

    @Serializable
    data class Genus(
        @SerialName("genus") val genus: String,
        @SerialName("language") val language: NamedApiResource
    )

    @Serializable
    data class Variety(
        @SerialName("is_default") val isDefault: Boolean,
        @SerialName("pokemon") val pokemon: NamedApiResource
    )
}