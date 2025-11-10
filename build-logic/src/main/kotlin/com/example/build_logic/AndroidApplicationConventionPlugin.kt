package com.example.build_logic

import com.android.build.api.dsl.ApplicationExtension
import com.example.pokeInfo.configureAndroidCommon
import com.example.pokeInfo.configureAndroidCompose
import com.example.pokeInfo.configureHilt
import com.example.pokeInfo.configureKotlinCompiler
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.android.application")
        pluginManager.apply("org.jetbrains.kotlin.android")
        pluginManager.apply("org.jetbrains.kotlin.plugin.compose")
        pluginManager.apply("com.google.devtools.ksp")
        pluginManager.apply("com.google.dagger.hilt.android")

        extensions.configure<ApplicationExtension> {
            val project = this@with
            project.configureAndroidCommon(this, includeConsumerProguard = false)
            project.configureAndroidCompose(this)

            defaultConfig {
                vectorDrawables.useSupportLibrary = true
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                    isDebuggable = false
                    isJniDebuggable = false
                    isPseudoLocalesEnabled = false
                }
                getByName("debug") {
                    isMinifyEnabled = false
                    isDebuggable = true
                    applicationIdSuffix = ".debug"
                    versionNameSuffix = "-debug"
                }
            }

            packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }

        configureHilt()
        configureKotlinCompiler(additionalFreeCompilerArgs = listOf("-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"))
    }
}
