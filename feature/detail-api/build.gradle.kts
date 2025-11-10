plugins {
    id("pokeinfo.android.library")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.navigation"
}

dependencies {
    api(project(":feature:main-api"))
    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.navigation)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
