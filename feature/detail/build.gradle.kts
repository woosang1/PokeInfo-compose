plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.compose")
    id("pokeinfo.android.hilt")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.detail"
}

dependencies {
    implementation(project(":domain:pokemon-api"))
    implementation(libs.androidx.core.ktx)
    implementation(project(":feature:detail-api"))
    implementation(project(":feature:main-api"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:utils"))
    implementation(project(":core:model"))
    implementation(project(":core:base"))
    implementation(project(":core:resource"))

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.coil.compose)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
