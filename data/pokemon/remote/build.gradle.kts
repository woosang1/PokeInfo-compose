plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.hilt")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.data.pokemon.remote"
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.androidx.core.ktx)
    implementation(project(":core:network"))
    implementation(project(":data:pokemon-api"))

    implementation(libs.retrofit2.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.paging.runtime)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
