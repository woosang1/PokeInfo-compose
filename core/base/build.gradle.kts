plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.compose")
}

android {
    namespace = "com.example.base"
}

dependencies {
    implementation(project(":core:utils"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.coil.compose)
    implementation(libs.kotlinx.collections.immutable)
}
