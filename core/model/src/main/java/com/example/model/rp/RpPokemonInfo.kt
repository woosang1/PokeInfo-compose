package com.example.model.rp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RpPokemonInfo(
    @SerialName("abilities")
    val abilities: List<Ability?>?,
    @SerialName("base_experience")
    val baseExperience: Int?,
    @SerialName("cries")
    val cries: Cries?,
    @SerialName("forms")
    val forms: List<Form?>?,
    @SerialName("game_indices")
    val gameIndices: List<GameIndice?>?,
    @SerialName("height")
    val height: Int?,
    @SerialName("held_items")
    val heldItems: List<String?>?,
    @SerialName("id")
    val id: Int?,
    @SerialName("is_default")
    val isDefault: Boolean?,
    @SerialName("location_area_encounters")
    val locationAreaEncounters: String?,
    @SerialName("moves")
    val moves: List<Move?>?,
    @SerialName("name")
    val name: String?,
    @SerialName("order")
    val order: Int?,
    @SerialName("past_abilities")
    val pastAbilities: List<String?>?,
    @SerialName("past_types")
    val pastTypes: List<String?>?,
    @SerialName("species")
    val species: Species?,
    @SerialName("sprites")
    val sprites: Sprites?,
    @SerialName("stats")
    val stats: List<Stat?>?,
    @SerialName("types")
    val types: List<Type?>?,
    @SerialName("weight")
    val weight: Int?
) {
    @Serializable
    data class Ability(
        @SerialName("ability")
        val ability: Ability?,
        @SerialName("is_hidden")
        val isHidden: Boolean?,
        @SerialName("slot")
        val slot: Int?
    ) {
        @Serializable
        data class Ability(
            @SerialName("name")
            val name: String?,
            @SerialName("url")
            val url: String?
        )
    }

    @Serializable
    data class Cries(
        @SerialName("latest")
        val latest: String?,
        @SerialName("legacy")
        val legacy: String?
    )

    @Serializable
    data class Form(
        @SerialName("name")
        val name: String?,
        @SerialName("url")
        val url: String?
    )

    @Serializable
    data class GameIndice(
        @SerialName("game_index")
        val gameIndex: Int?,
        @SerialName("version")
        val version: Version?
    ) {
        @Serializable
        data class Version(
            @SerialName("name")
            val name: String?,
            @SerialName("url")
            val url: String?
        )
    }

    @Serializable
    data class Move(
        @SerialName("move")
        val move: Move?,
        @SerialName("version_group_details")
        val versionGroupDetails: List<VersionGroupDetail?>?
    ) {
        @Serializable
        data class Move(
            @SerialName("name")
            val name: String?,
            @SerialName("url")
            val url: String?
        )

        @Serializable
        data class VersionGroupDetail(
            @SerialName("level_learned_at")
            val levelLearnedAt: Int?,
            @SerialName("move_learn_method")
            val moveLearnMethod: MoveLearnMethod?,
            @SerialName("order")
            val order: Int?,
            @SerialName("version_group")
            val versionGroup: VersionGroup?
        ) {
            @Serializable
            data class MoveLearnMethod(
                @SerialName("name")
                val name: String?,
                @SerialName("url")
                val url: String?
            )

            @Serializable
            data class VersionGroup(
                @SerialName("name")
                val name: String?,
                @SerialName("url")
                val url: String?
            )
        }
    }

    @Serializable
    data class Species(
        @SerialName("name")
        val name: String?,
        @SerialName("url")
        val url: String?
    )

    @Serializable
    data class Sprites(
        @SerialName("back_default")
        val backDefault: String?,
        @SerialName("back_female")
        val backFemale: String?,
        @SerialName("back_shiny")
        val backShiny: String?,
        @SerialName("back_shiny_female")
        val backShinyFemale: String?,
        @SerialName("front_default")
        val frontDefault: String?,
        @SerialName("front_female")
        val frontFemale: String?,
        @SerialName("front_shiny")
        val frontShiny: String?,
        @SerialName("front_shiny_female")
        val frontShinyFemale: String?,
        @SerialName("other")
        val other: Other?,
        @SerialName("versions")
        val versions: Versions?
    ) {
        @Serializable
        data class Other(
            @SerialName("dream_world")
            val dreamWorld: DreamWorld?,
            @SerialName("home")
            val home: Home?,
            @SerialName("official-artwork")
            val officialArtwork: OfficialArtwork?,
            @SerialName("showdown")
            val showdown: Showdown?
        ) {
            @Serializable
            data class DreamWorld(
                @SerialName("front_default")
                val frontDefault: String?,
                @SerialName("front_female")
                val frontFemale: String?
            )

            @Serializable
            data class Home(
                @SerialName("front_default")
                val frontDefault: String?,
                @SerialName("front_female")
                val frontFemale: String?,
                @SerialName("front_shiny")
                val frontShiny: String?,
                @SerialName("front_shiny_female")
                val frontShinyFemale: String?
            )

            @Serializable
            data class OfficialArtwork(
                @SerialName("front_default")
                val frontDefault: String?,
                @SerialName("front_shiny")
                val frontShiny: String?
            )

            @Serializable
            data class Showdown(
                @SerialName("back_default")
                val backDefault: String?,
                @SerialName("back_female")
                val backFemale: String?,
                @SerialName("back_shiny")
                val backShiny: String?,
                @SerialName("back_shiny_female")
                val backShinyFemale: String?,
                @SerialName("front_default")
                val frontDefault: String?,
                @SerialName("front_female")
                val frontFemale: String?,
                @SerialName("front_shiny")
                val frontShiny: String?,
                @SerialName("front_shiny_female")
                val frontShinyFemale: String?
            )
        }

        @Serializable
        data class Versions(
            @SerialName("generation-i")
            val generationI: GenerationI?,
            @SerialName("generation-ii")
            val generationIi: GenerationIi?,
            @SerialName("generation-iii")
            val generationIii: GenerationIii?,
            @SerialName("generation-iv")
            val generationIv: GenerationIv?,
            @SerialName("generation-v")
            val generationV: GenerationV?,
            @SerialName("generation-vi")
            val generationVi: GenerationVi?,
            @SerialName("generation-vii")
            val generationVii: GenerationVii?,
            @SerialName("generation-viii")
            val generationViii: GenerationViii?
        ) {
            @Serializable
            data class GenerationI(
                @SerialName("red-blue")
                val redBlue: RedBlue?,
                @SerialName("yellow")
                val yellow: Yellow?
            ) {
                @Serializable
                data class RedBlue(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_gray")
                    val backGray: String?,
                    @SerialName("back_transparent")
                    val backTransparent: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_gray")
                    val frontGray: String?,
                    @SerialName("front_transparent")
                    val frontTransparent: String?
                )

                @Serializable
                data class Yellow(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_gray")
                    val backGray: String?,
                    @SerialName("back_transparent")
                    val backTransparent: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_gray")
                    val frontGray: String?,
                    @SerialName("front_transparent")
                    val frontTransparent: String?
                )
            }

            @Serializable
            data class GenerationIi(
                @SerialName("crystal")
                val crystal: Crystal?,
                @SerialName("gold")
                val gold: Gold?,
                @SerialName("silver")
                val silver: Silver?
            ) {
                @Serializable
                data class Crystal(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_shiny")
                    val backShiny: String?,
                    @SerialName("back_shiny_transparent")
                    val backShinyTransparent: String?,
                    @SerialName("back_transparent")
                    val backTransparent: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_shiny_transparent")
                    val frontShinyTransparent: String?,
                    @SerialName("front_transparent")
                    val frontTransparent: String?
                )

                @Serializable
                data class Gold(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_shiny")
                    val backShiny: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_transparent")
                    val frontTransparent: String?
                )

                @Serializable
                data class Silver(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_shiny")
                    val backShiny: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_transparent")
                    val frontTransparent: String?
                )
            }

            @Serializable
            data class GenerationIii(
                @SerialName("emerald")
                val emerald: Emerald?,
                @SerialName("firered-leafgreen")
                val fireredLeafgreen: FireredLeafgreen?,
                @SerialName("ruby-sapphire")
                val rubySapphire: RubySapphire?
            ) {
                @Serializable
                data class Emerald(
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?
                )

                @Serializable
                data class FireredLeafgreen(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_shiny")
                    val backShiny: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?
                )

                @Serializable
                data class RubySapphire(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_shiny")
                    val backShiny: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?
                )
            }

            @Serializable
            data class GenerationIv(
                @SerialName("diamond-pearl")
                val diamondPearl: DiamondPearl?,
                @SerialName("heartgold-soulsilver")
                val heartgoldSoulsilver: HeartgoldSoulsilver?,
                @SerialName("platinum")
                val platinum: Platinum?
            ) {
                @Serializable
                data class DiamondPearl(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_female")
                    val backFemale: String?,
                    @SerialName("back_shiny")
                    val backShiny: String?,
                    @SerialName("back_shiny_female")
                    val backShinyFemale: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_female")
                    val frontFemale: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String?
                )

                @Serializable
                data class HeartgoldSoulsilver(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_female")
                    val backFemale: String?,
                    @SerialName("back_shiny")
                    val backShiny: String?,
                    @SerialName("back_shiny_female")
                    val backShinyFemale: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_female")
                    val frontFemale: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String?
                )

                @Serializable
                data class Platinum(
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_female")
                    val backFemale: String?,
                    @SerialName("back_shiny")
                    val backShiny: String?,
                    @SerialName("back_shiny_female")
                    val backShinyFemale: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_female")
                    val frontFemale: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String?
                )
            }

            @Serializable
            data class GenerationV(
                @SerialName("black-white")
                val blackWhite: BlackWhite?
            ) {
                @Serializable
                data class BlackWhite(
                    @SerialName("animated")
                    val animated: Animated?,
                    @SerialName("back_default")
                    val backDefault: String?,
                    @SerialName("back_female")
                    val backFemale: String?,
                    @SerialName("back_shiny")
                    val backShiny: String?,
                    @SerialName("back_shiny_female")
                    val backShinyFemale: String?,
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_female")
                    val frontFemale: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String?
                ) {
                    @Serializable
                    data class Animated(
                        @SerialName("back_default")
                        val backDefault: String?,
                        @SerialName("back_female")
                        val backFemale: String?,
                        @SerialName("back_shiny")
                        val backShiny: String?,
                        @SerialName("back_shiny_female")
                        val backShinyFemale: String?,
                        @SerialName("front_default")
                        val frontDefault: String?,
                        @SerialName("front_female")
                        val frontFemale: String?,
                        @SerialName("front_shiny")
                        val frontShiny: String?,
                        @SerialName("front_shiny_female")
                        val frontShinyFemale: String?
                    )
                }
            }

            @Serializable
            data class GenerationVi(
                @SerialName("omegaruby-alphasapphire")
                val omegarubyAlphasapphire: OmegarubyAlphasapphire?,
                @SerialName("x-y")
                val xY: XY?
            ) {
                @Serializable
                data class OmegarubyAlphasapphire(
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_female")
                    val frontFemale: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String?
                )

                @Serializable
                data class XY(
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_female")
                    val frontFemale: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String?
                )
            }

            @Serializable
            data class GenerationVii(
                @SerialName("icons")
                val icons: Icons?,
                @SerialName("ultra-sun-ultra-moon")
                val ultraSunUltraMoon: UltraSunUltraMoon?
            ) {
                @Serializable
                data class Icons(
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_female")
                    val frontFemale: String?
                )

                @Serializable
                data class UltraSunUltraMoon(
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_female")
                    val frontFemale: String?,
                    @SerialName("front_shiny")
                    val frontShiny: String?,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String?
                )
            }

            @Serializable
            data class GenerationViii(
                @SerialName("icons")
                val icons: Icons?
            ) {
                @Serializable
                data class Icons(
                    @SerialName("front_default")
                    val frontDefault: String?,
                    @SerialName("front_female")
                    val frontFemale: String?
                )
            }
        }
    }

    @Serializable
    data class Stat(
        @SerialName("base_stat")
        val baseStat: Int?,
        @SerialName("effort")
        val effort: Int?,
        @SerialName("stat")
        val stat: Stat?
    ) {
        @Serializable
        data class Stat(
            @SerialName("name")
            val name: String?,
            @SerialName("url")
            val url: String?
        )
    }

    @Serializable
    data class Type(
        @SerialName("slot")
        val slot: Int?,
        @SerialName("type")
        val type: Type?
    ) {
        @Serializable
        data class Type(
            @SerialName("name")
            val name: String?,
            @SerialName("url")
            val url: String?
        )
    }
}