package com.example.detail.detail.common


enum class TabType(val title: String, val description: String){
    ABOUT(title = "About", description = "포켓몬 설명"),
    BASE_STATS(title = "Base Stats", description = "능력치"),
    EVOLUTION(title = "Evolution", description = "진화"),
    MOVES(title = "Moves", description = "영상")
}