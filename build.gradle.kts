import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.20"
    id("io.qameta.allure") version "2.8.1"
    java
}

group = "playwright-kotlin-junit5"
version = "1.0"

description = "REST API Test with Rest Assured and Kotlin"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hamcrest:hamcrest:2.2")
    implementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.20-M1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.20-M1")
    testImplementation("io.rest-assured:rest-assured:4.4.0")
    testImplementation("io.rest-assured:kotlin-extensions:4.4.0")
    testImplementation("io.rest-assured:json-schema-validator:4.4.0")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.8.+")
    testImplementation("com.github.javafaker:javafaker:1.0.2")
    implementation("com.microsoft.playwright:playwright:1.31.0")
    testImplementation("io.qameta.allure:allure-junit5:2.14.0")
    implementation("io.qameta.allure:allure-okhttp3:2.10.0")
    implementation(kotlin("script-runtime"))
    implementation(kotlin("stdlib-jdk8"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

allure {
    version = "2.14.0"
    downloadLinkFormat = "https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.14.0/allure-commandline-2.14.0.zip"
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        exceptionFormat = TestExceptionFormat.SHORT
        showCauses = true
        showExceptions = true
        showStackTraces = true
        maxHeapSize = "2G"
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}