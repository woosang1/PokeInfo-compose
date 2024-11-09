pluginManagement {
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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokeInfo"
include(":app")
include(":core")
include(":core:designsystem")
include(":core:domain")
include(":core:data")
include(":core:ui")
include(":feature")
include(":feature:main")
include(":core:utils")
include(":feature:detail")
include(":feature:home")
