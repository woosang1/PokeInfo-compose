plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.compose")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.ui"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:utils"))
    implementation(project(":core:model"))
    implementation(project(":core:resource"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.coil.compose)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.lottie.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
