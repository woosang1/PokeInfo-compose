plugins {
    id("pokeinfo.android.library")
}

android {
    namespace = "com.example.home.api"
}

dependencies {
    api(project(":feature:main-api"))
    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.navigation)

    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
