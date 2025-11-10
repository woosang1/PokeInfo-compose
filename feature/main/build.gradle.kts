plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.compose")
    id("pokeinfo.android.hilt")
}

android {
    namespace = "com.example.main"
}

dependencies {
    implementation(project(":feature:main-api"))
    implementation(libs.androidx.core.ktx)
    implementation(project(":feature:home-api"))
    implementation(project(":feature:detail-api"))
    implementation(project(":feature:home"))
    implementation(project(":feature:detail"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:utils"))
    implementation(project(":core:model"))
    implementation(project(":core:base"))

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.coil.compose)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.hilt.navigation.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
