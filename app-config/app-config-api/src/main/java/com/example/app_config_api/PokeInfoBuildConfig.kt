package com.example.app_config_api

interface PokeInfoBuildConfig {
    fun isDebug(): Boolean = true
    fun isProduction(): Boolean = false
    fun getVersionName(): String = "1.0.0"
    fun getNetworkUrl(): String = ""
}

