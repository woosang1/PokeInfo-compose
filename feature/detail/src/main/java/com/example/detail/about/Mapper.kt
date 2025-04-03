package com.example.detail.about

import com.example.model.ui.AboutModel
import com.example.model.ui.Pokemon

fun Pokemon.toAboutModel(): AboutModel {
    return AboutModel(description = this.description)
}