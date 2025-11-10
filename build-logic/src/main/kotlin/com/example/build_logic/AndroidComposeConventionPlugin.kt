package com.example.build_logic

import com.example.pokeInfo.androidCommonExtension
import com.example.pokeInfo.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

        val extension = androidCommonExtension()
        configureAndroidCompose(extension)
    }
}
