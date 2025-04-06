package com.example.component.common

import androidx.compose.ui.graphics.Color
import com.example.designsystem.theme.ColorSystem
import com.example.designsystem.theme.lightColors


fun String.getPokemonColorByColor(colorSystem: ColorSystem = lightColors): Color {
    return when (this.lowercase()) {
        "black" -> colorSystem.black
        "blue" -> colorSystem.blue
        "brown" -> colorSystem.brown
        "gray" -> colorSystem.gray
        "green" -> colorSystem.green
        "pink" -> colorSystem.pink
        "purple" -> colorSystem.purple80
        "red" -> colorSystem.red
        "white" -> colorSystem.white
        "yellow" -> colorSystem.yellow
        else -> colorSystem.lightGray
    }
}

fun String.getPokemonColorType(colorSystem: ColorSystem = lightColors): Color {
    return when (this.lowercase()) {
        "normal" -> colorSystem.beige
        "fire" -> colorSystem.orange
        "water" -> colorSystem.blue
        "electric" -> colorSystem.yellow
        "grass" -> colorSystem.green
        "ice" -> colorSystem.lightBlue
        "fighting" -> colorSystem.red
        "poison" -> colorSystem.purple80
        "ground" -> colorSystem.brown
        "flying" -> colorSystem.softGreen
        "psychic" -> colorSystem.pink
        "bug" -> colorSystem.lightGreen
        "rock" -> colorSystem.darkGray
        "ghost" -> colorSystem.violet
        "dragon" -> colorSystem.deepBlue
        "dark" -> colorSystem.black
        "steel" -> colorSystem.silver
        "fairy" -> colorSystem.pink
        else -> colorSystem.lightGray
    }
}
