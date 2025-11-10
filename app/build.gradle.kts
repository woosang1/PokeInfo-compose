plugins {
    id("pokeinfo.android.application")
}

android {
    namespace = "com.example.pokeinfo"

    defaultConfig {
        applicationId = "com.example.pokeinfo"
        versionCode = 1
        versionName = "1.0.0"
    }
}

dependencies {
    implementation(project(":feature:main"))
    implementation(project(":domain:pokemon"))
    implementation(project(":data:pokemon"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.kotlinx.collections.immutable)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
