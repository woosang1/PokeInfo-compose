import com.example.pokeInfo.configureHiltAndroid
import com.example.pokeInfo.libs

plugins {
    id("droidknights.android.library")
    id("droidknights.android.compose")
}

android {
    packaging {
        resources {
            excludes.add("META-INF/**")
        }
    }
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

configureHiltAndroid()
//configureRoborazzi()

dependencies {
    implementation(project(":core:model"))
    implementation(project(":data:pokemon-api"))
    implementation(project(":core:designsystem"))
    implementation(project(":domain:pokemon-api"))
    implementation(project(":core:ui"))

    testImplementation(project(":core:testing"))

    val libs = project.extensions.libs
    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("androidx.compose.navigation").get())
    androidTestImplementation(libs.findLibrary("androidx.compose.navigation.test").get())

    implementation(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
    implementation(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
}
