package com.example.detail.baseStats

import com.example.model.ui.BaseStatsModel
import com.example.model.ui.Pokemon

fun Pokemon.toBaseStatsModel(): BaseStatsModel {
    return BaseStatsModel(
        hp = this.stats.hp,
        attack = this.stats.attack,
        defense = this.stats.defense,
        specialAttack = this.stats.specialAttack,
        specialDefense = this.stats.specialDefense,
        speed = this.stats.speed,
        total = this.stats.total
    )
}
