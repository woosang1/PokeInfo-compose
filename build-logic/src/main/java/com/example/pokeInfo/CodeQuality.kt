plugins {
    id("io.gitlab.arturbosch.detekt") version "1.23.6"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}

// Detekt 설정
detekt {
    buildUponDefaultConfig = true
    allRules = false
    config.setFrom("$projectDir/config/detekt.yml")
    baseline = file("$projectDir/config/baseline.xml")
}

// Ktlint 설정
ktlint {
    version.set("1.2.1")
    debug.set(true)
    verbose.set(true)
    android.set(true)
    outputToConsole.set(true)
    outputColorName.set("RED")
    ignoreFailures.set(false)
    enableExperimentalRules.set(true)
}

tasks.register("codeQuality") {
    dependsOn("ktlintCheck", "detekt")
    description = "Run all code quality checks"
    group = "verification"
}
