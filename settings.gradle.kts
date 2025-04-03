pluginManagement {
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

// Feature Modules
include(":feature")
include(":feature:main")
include(":feature:home")
include(":feature:detail")

// Core Modules
include(":core")
include(":data")
include(":domain")
include(":core:ui")
include(":core:designsystem")
include(":core:utils")
include(":core:network")
include(":core:model")
include(":core:database")




include(":core:resource")
include(":core:navigation")
include(":core:base")
