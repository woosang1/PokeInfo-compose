pluginManagement {
//    include("build-logic")
    include(":build-logic")
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

// Core Modules
include(":core")
include(":data")
include(":domain")
include(":core:ui")
include(":core:designsystem")
include(":core:utils")

// Feature Modules
include(":feature")
include(":feature:main")
include(":feature:home")
include(":feature:detail")

// Build Logic
//include(":build-logic")
include(":core:network")
include(":core:model")
