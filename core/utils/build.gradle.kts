plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.compose")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.utils"
}

dependencies {
    implementation(project(":core:resource"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.coil.compose)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.window)
    implementation(libs.retrofit2.retrofit)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
}
