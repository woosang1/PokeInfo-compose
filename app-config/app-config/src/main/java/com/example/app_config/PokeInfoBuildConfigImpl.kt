package com.example.app_config

import com.example.app_config_api.PokeInfoBuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class PokeInfoBuildConfigImpl @Inject constructor() : PokeInfoBuildConfig {
    override fun isDebug(): Boolean = BuildConfig.DEBUG
    override fun isProduction(): Boolean = !BuildConfig.IS_TEST_SERVER && !BuildConfig.DEBUG
    override fun getVersionName(): String = "1.0.0"
    override fun getNetworkUrl(): String = BuildConfig.BASE_URL
}

