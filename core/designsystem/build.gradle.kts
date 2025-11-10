plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.compose")
}

android {
    namespace = "com.example.designsystem"
}

dependencies {
    implementation(project(":core:utils"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
