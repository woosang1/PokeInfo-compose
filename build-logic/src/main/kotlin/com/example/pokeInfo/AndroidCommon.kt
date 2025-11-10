package com.example.pokeInfo

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.maybeCreate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureAndroidCommon(
    extension: CommonExtension<*, *, *, *, *, *>,
    includeConsumerProguard: Boolean,
) {
    val libs = libs
    extension.apply {
        compileSdk = libs.findVersion("compileSdk").get().requiredVersion.toInt()

        defaultConfig {
            minSdk = libs.findVersion("minSdk").get().requiredVersion.toInt()
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        if (!flavorDimensions.contains(EnvironmentFlavors.DIMENSION)) {
            flavorDimensions += EnvironmentFlavors.DIMENSION
        }
        productFlavors {
            maybeCreate(EnvironmentFlavors.DEV).dimension = EnvironmentFlavors.DIMENSION
            maybeCreate(EnvironmentFlavors.PROD).dimension = EnvironmentFlavors.DIMENSION
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }

    if (includeConsumerProguard && extension is LibraryExtension) {
        extension.defaultConfig.consumerProguardFiles("consumer-rules.pro")
    }
}

internal fun Project.configureKotlinCompiler(
    additionalFreeCompilerArgs: List<String> = emptyList(),
) {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
            val updated = (freeCompilerArgs.getOrElse(emptyList()) +
                listOf("-opt-in=kotlin.RequiresOptIn") +
                additionalFreeCompilerArgs).distinct()
            freeCompilerArgs.set(updated)
        }
    }
}
