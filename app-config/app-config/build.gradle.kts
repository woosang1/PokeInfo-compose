plugins {
    id("pokeinfo.android.library")
    id("pokeinfo.android.hilt")
}

android {
    namespace = "com.example.app_config"

    buildFeatures {
        buildConfig = true
    }

    productFlavors {
        named("dev") {
            buildConfigField("Boolean", "IS_TEST_SERVER", "true")
            buildConfigField("String", "BASE_URL", "\"https://pokeapi.co/api/v2/\"")
        }
        named("prod") {
            buildConfigField("Boolean", "IS_TEST_SERVER", "false")
            buildConfigField("String", "BASE_URL", "\"https://pokeapi.co/api/v2/\"")
        }
    }
}

dependencies {
    implementation(project(":app-config:app-config-api"))
    implementation(project(":core:resource"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}

