package com.example.pokeInfo

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "com.example.$name"
    }
}