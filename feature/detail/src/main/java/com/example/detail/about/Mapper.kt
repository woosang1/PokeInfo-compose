package com.example.detail.about

import com.example.model.ui.AboutModel
import com.example.model.ui.Pokemon

fun Pokemon.toAboutModel(): AboutModel {
    return AboutModel(
        description = this.description,
        height = this.height,
        weight = this.weight,
        genderRate = this.genderRate,
        eddGroups = this.eggGroups,
        eggCycle = this.eggCycle
    )
}