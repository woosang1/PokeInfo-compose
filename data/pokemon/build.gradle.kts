plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.compose")
    id("pokeinfo.android.hilt")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.data"
}

dependencies {
    implementation(project(":data:pokemon-api"))
    implementation(libs.androidx.core.ktx)
    implementation(project(":core:utils"))
    implementation(project(":core:network"))
    implementation(project(":core:model"))
    implementation(project(":core:database"))

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.retrofit2.retrofit)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.gson)
    implementation(libs.gson)

    ksp(libs.androidx.room.compiler)

    testImplementation(libs.junit)
    testImplementation(libs.turbine)
    testImplementation(libs.kotest.runner)
    testImplementation(libs.kotest.assertions)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
