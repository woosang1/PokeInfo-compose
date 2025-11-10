package com.example.build_logic

import com.android.build.api.dsl.LibraryExtension
import com.example.pokeInfo.configureAndroidCommon
import com.example.pokeInfo.configureKotlinCompiler
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.android.library")
        pluginManager.apply("org.jetbrains.kotlin.android")

        extensions.configure<LibraryExtension> {
            configureAndroidCommon(this, includeConsumerProguard = true)
        }

        configureKotlinCompiler()
    }
}
