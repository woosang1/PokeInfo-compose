package com.example.detail.about

import com.example.model.ui.AboutModel
import com.example.model.ui.Pokemon

fun Pokemon.toAboutModel(): AboutModel {
    return AboutModel(
        description = this.description,
        height = this.height,
        weight = this.weight,
        genderRate = this.genderRate, // 추가됨
        eddGroups = this.eggGroups, // 추가됨
        eggCycle = this.eggCycle // 추가됨
    )
}