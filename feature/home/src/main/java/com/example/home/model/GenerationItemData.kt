package com.example.home.model

import androidx.annotation.DrawableRes

data class GenerationItemData(
    val generation: Int,
    val title: String,
    @DrawableRes val imageRes: Int
)
