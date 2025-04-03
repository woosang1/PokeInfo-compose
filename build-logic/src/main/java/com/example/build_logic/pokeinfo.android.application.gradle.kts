import com.example.pokeInfo.configureHiltAndroid
import com.example.pokeInfo.configureKotestAndroid
import com.example.pokeInfo.configureKotlinAndroid

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android.ksp)
}

configureKotlinAndroid()
configureHiltAndroid()
configureKotestAndroid()

