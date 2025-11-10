import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    `kotlin-dsl`}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    implementation(libs.findLibrary("android-gradlePlugin").get())
    implementation(libs.findLibrary("kotlin-gradlePlugin").get())
    implementation(libs.findLibrary("compose-compiler-gradle-plugin").get())
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.6")
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "pokeinfo.android.application"
            implementationClass = "com.example.build_logic.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "pokeinfo.android.library"
            implementationClass = "com.example.build_logic.AndroidLibraryConventionPlugin"
        }
        register("androidCompose") {
            id = "pokeinfo.android.compose"
            implementationClass = "com.example.build_logic.AndroidComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "pokeinfo.android.hilt"
            implementationClass = "com.example.build_logic.AndroidHiltConventionPlugin"
        }
    }
}
