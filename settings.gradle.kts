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

// Core Modules
include(":core")
include(":core:data")
include(":core:domain")
include(":core:ui")
include(":core:designsystem")
include(":core:utils")

// Feature Modules
include(":feature")
include(":feature:main")
include(":feature:home")
include(":feature:detail")

// Application Module
include(":app")

// Build Logic
//include(":build-logic")
