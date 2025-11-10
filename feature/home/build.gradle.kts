plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.compose")
    id("pokeinfo.android.hilt")
}

android {
    namespace = "com.example.home"
}

dependencies {
    implementation(project(":domain:pokemon-api"))
    implementation(libs.androidx.core.ktx)
    implementation(project(":feature:main-api"))
    implementation(project(":feature:home-api"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:utils"))
    implementation(project(":core:model"))
    implementation(project(":core:base"))
    implementation(project(":core:resource"))
    implementation(project(":core:testing"))

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.coil.compose)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.speeddial)
    implementation(libs.androidx.window)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.turbine)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
