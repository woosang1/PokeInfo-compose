import com.example.pokeInfo.configureHiltAndroid
import com.example.pokeInfo.configureKotestAndroid
import com.example.pokeInfo.configureKotlinAndroid

plugins {
//    id("com.android.application")
//    alias(libs.plugins.android.application)

    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

configureKotlinAndroid()
configureHiltAndroid()
configureKotestAndroid()
//configureRoborazzi()

