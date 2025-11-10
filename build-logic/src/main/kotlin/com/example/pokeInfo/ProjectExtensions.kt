package com.example.pokeInfo

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

@Suppress("UNCHECKED_CAST")
internal fun Project.androidCommonExtension(): CommonExtension<*, *, *, *, *, *> {
    return extensions.findByName("android") as? CommonExtension<*, *, *, *, *, *>
        ?: throw IllegalStateException("Android extension not found on project '$name'")
}

internal fun Project.applicationExtension(): ApplicationExtension =
    extensions.getByType(ApplicationExtension::class.java)

internal fun Project.libraryExtension(): LibraryExtension =
    extensions.getByType(LibraryExtension::class.java)
