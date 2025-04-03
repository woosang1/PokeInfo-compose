package com.example.detail.evolution

import com.example.model.ui.EvolutionModel
import com.example.model.ui.Pokemon

fun Pokemon.toEvolutionModel(): EvolutionModel {
    return EvolutionModel(
        hp = this.stats["hp"] ?: 0,
        attack = this.stats["attack"] ?: 0,
        defense = this.stats["defense"] ?: 0,
        specialAttack = this.stats["special-attack"] ?: 0,
        specialDefense = this.stats["special-defense"] ?: 0,
        speed = this.stats["speed"] ?: 0,
        total = this.stats.values.sum() // 모든 스탯 합산
    )
}

