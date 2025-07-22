plugins {
    base
    kotlin("jvm") version "2.2.0" apply false
    id("com.gradleup.shadow") version "8.3.0" apply false
    id("xyz.jpenilla.run-paper") version "2.3.1" apply false
}

group = "DevMinecraft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

subprojects {
    plugins.withId("org.jetbrains.kotlin.jvm") {
        extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension>("kotlin") {
            jvmToolchain(21)
        }
    }

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://oss.sonatype.org/content/groups/public/")
    }
}

tasks.register<Delete>("cleanRunBuild") {
    delete(file("run/build"))
}

tasks.named("clean") {
    dependsOn("cleanRunBuild")
}
