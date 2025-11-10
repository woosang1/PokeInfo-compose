plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.compose")
    id("pokeinfo.android.hilt")
}

android {
    namespace = "com.example.domain"
}

dependencies {
    implementation(project(":domain:pokemon-api"))
    implementation(libs.androidx.core.ktx)
    implementation(project(":data:pokemon-api"))
    implementation(project(":core:utils"))
    implementation(project(":core:model"))

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)

    testImplementation(libs.junit)
    testImplementation(libs.turbine)
    testImplementation(libs.kotest.runner)
    testImplementation(libs.kotest.assertions)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
