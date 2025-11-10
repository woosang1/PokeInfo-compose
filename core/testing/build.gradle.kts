plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.hilt")
}

android {
    namespace = "com.example.testing"
}

dependencies {
    api(libs.coroutines.test)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.junit)
    testImplementation(libs.androidx.hilt.work)
    testImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    kspTest(libs.hilt.android.compiler)
}
