package com.example.pokeInfo

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHilt() {
    val libs = libs
    dependencies {
        add("implementation", libs.findLibrary("hilt-android").get())
        add("ksp", libs.findLibrary("hilt-android-compiler").get())
        add("ksp", libs.findLibrary("androidx-hilt-compiler").get())
    }
}
