plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(project(":core:domain"))
    implementation(project(":core:utils"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.kotlinx.serialization.json)

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.8.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    // hilt
    implementation("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")

    // room
    implementation("androidx.room:room-runtime:${Versions.room}")
    implementation("androidx.room:room-ktx:${Versions.room}")
    kapt("androidx.room:room-compiler:${Versions.room}")

    // Retrofit 및 관련 의존성 추가
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.8.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")

    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")

}