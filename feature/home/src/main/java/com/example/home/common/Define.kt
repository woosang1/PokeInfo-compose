package com.example.home.common

enum class MenuType(val title: String){
    FAVORITE("찜"),
    ALL_TYPE("모든 타입"),
    GENERATION("모든 세대"),
}

fun getIdRangeForGeneration(generation: Int): IntRange = when (generation) {
    1 -> 1..151
    2 -> 152..251
    3 -> 252..386
    4 -> 387..493
    5 -> 494..649
    6 -> 650..721
    7 -> 722..809
    8 -> 810..898
    else -> IntRange.EMPTY
}