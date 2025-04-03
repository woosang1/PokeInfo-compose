package com.example.detail.baseStats

import com.example.model.ui.BaseStatsModel
import com.example.model.ui.Pokemon

fun Pokemon.toBaseStatsModel(): BaseStatsModel {
    return BaseStatsModel(
        description = this.description,
        height = this.height,
        weight = this.weight,
        genderRate = this.genderRate, // 추가됨
        eddGroups = this.eggGroups, // 추가됨
        eggCycle = this.eggCycle // 추가됨
    )
}
