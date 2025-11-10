plugins {
    id("pokeinfo.android.library")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.navigation"
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
