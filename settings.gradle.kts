pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokeInfo"

// Application Module
include(":app")

// App Config Modules
include(":app-config:app-config")
include(":app-config:app-config-api")

// Feature Modules
include(":feature")
include(":feature:main")
include(":feature:main-api")
include(":feature:home")
include(":feature:home-api")
include(":feature:detail")
include(":feature:detail-api")

// Data Modules
include(":data:pokemon")
include(":data:pokemon-api")

// Domain Modules
include(":domain:pokemon")
include(":domain:pokemon-api")

// Core Modules
include(":core:ui")
include(":core:designsystem")
include(":core:utils")
include(":core:network")
include(":core:model")
include(":core:database")
include(":core:resource")
include(":core:base")
include(":core:testing")
